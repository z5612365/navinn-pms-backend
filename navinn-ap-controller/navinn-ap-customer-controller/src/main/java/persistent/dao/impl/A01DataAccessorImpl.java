package persistent.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import persistent.dao.A01DataAccessor;
import persistent.model.bean.BookingInfoDo;
import persistent.model.bean.OrderPo;

import org.springframework.jdbc.core.JdbcTemplate;
import persistent.model.bean.PaymentPo;
import persistent.model.bean.RoomPo;
import persistent.model.mapper.BookingInfoDoRowMapper;
import persistent.model.mapper.RoomPoRowMapper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class A01DataAccessorImpl implements A01DataAccessor {

    private final String navinn_wallet_addr = "xNVVuFAbwr5jnTBTsisCseq4J2NXzvtqo7McvLAKfHYi7PHs7ybHSduVcp79mo69x4nTsb4sVcFiRQd45wzNZV8STSGUiyPzka9ucXJ2KdJfMgEerWgRaXAdPXPp97zPC6Pav1hySeq";

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    private OrderPo order;

    @Override
    public OrderPo getOrderInfo() {
        return order;
    }

    @Override
    public List<RoomPo> getRoomInfo() {

        String sql = "SELECT ROOM_SEQ, ROOM_NAME, ROOM_URL, ROOM_ALT, ROOM_DESC, ROOM_SPEC, ROOM_PRICE FROM TB_ROOM;";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        System.out.println("rows " + rows);

        List<RoomPo> roomPoList = new ArrayList<>();
        for (Map row : rows) {
            RoomPo obj = new RoomPo();
            obj.setRoomSeq(((Integer) row.get("ROOM_SEQ")).toString());
            obj.setRoomName(((String) row.get("ROOM_NAME")));
            obj.setRoomUrl(((String) row.get("ROOM_URL")));
            obj.setRoomAlt(((String) row.get("ROOM_ALT")));
            obj.setRoomDesc(((String) row.get("ROOM_DESC")));
            obj.setRoomSpec(((String) row.get("ROOM_SPEC")));
            obj.setRoomPrice((BigDecimal) row.get("ROOM_PRICE"));
            roomPoList.add(obj);
        }
        return roomPoList;
    }

    @Override
    public RoomPo getRoomInfoByRoomSeq(String roomSeq) {
        String sql = "SELECT ROOM_SEQ, ROOM_NAME, ROOM_URL, ROOM_ALT, ROOM_DESC, ROOM_SPEC, ROOM_PRICE FROM TB_ROOM WHERE ROOM_SEQ=?;";
        RoomPo roomPo = (RoomPo) jdbcTemplate.queryForObject(sql, new RoomPoRowMapper(), new Object[]{roomSeq});
        return roomPo;
    }

    @Override
    public String booking(String roomSeq, List<String> bookDateList) {

        int min = 1;
        int max = 9999;
        Random random = new Random();
        String paymentKey = String.format("%03d", random.nextInt(max + min) + min);//four Digit Value

        String sql = "SELECT ROOM_PRICE FROM TB_ROOM WHERE ROOM_SEQ = ?;";
        BigDecimal roomPrice = jdbcTemplate.queryForObject(sql, BigDecimal.class, new Object[]{roomSeq});
        BigDecimal totalPrice = roomPrice.multiply(new BigDecimal(bookDateList.size()));

        //TODO GET ROMM PRICE BY PAYMENT_KEY
        //set navinn_wallet_addr

        jdbcTemplate.update(
                "INSERT INTO TB_PAYMENT ( PAYMENT_KEY, RECEIVE_WALLET, TOTAL_AMOUNT, STATUS ) VALUES ( ?, ?, ?, ? )",
                paymentKey, navinn_wallet_addr, totalPrice, "UNPAID"
        );

        for (String bookDate : bookDateList) {
            jdbcTemplate.update(
                    "INSERT INTO TB_BOOKING ( ROOM_SEQ, PAYMENT_KEY, BOOK_DATE ) VALUES ( ?, ?, ? )",
                    roomSeq, paymentKey, bookDate
            );

        }

        return paymentKey;
    }

    @Override
    public List<String> getBookedDate(String roomSeq) {
        String sql = "SELECT TB.BOOK_DATE FROM TB_PAYMENT AS TP JOIN TB_BOOKING AS TB ON TP.PAYMENT_KEY=TB.PAYMENT_KEY WHERE TP.STATUS<>\"CANCEL\" AND TB.ROOM_SEQ=" + roomSeq + ";";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        System.out.println("rows " + rows);

        List<String> bookedDateList = new ArrayList<>();
        for (Map row : rows) {
            bookedDateList.add((String) row.get("BOOK_DATE"));
        }
        return bookedDateList;
    }

    @Override
    public List<PaymentPo> getPaymentHistory() {
        String sql = "SELECT TP.PAYMENT_KEY, TP.RECEIVE_WALLET, TP.TOTAL_AMOUNT, TP.STATUS FROM TB_PAYMENT AS TP;";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        System.out.println("rows " + rows);

        List<PaymentPo> roomPoList = new ArrayList<>();
        for (Map row : rows) {
            PaymentPo obj = new PaymentPo();
            obj.setPaymentKey(((String) row.get("PAYMENT_KEY")));
            obj.setReceiveWallet(((String) row.get("RECEIVE_WALLET")));
            obj.setTotalAmount((BigDecimal) row.get("TOTAL_AMOUNT"));
            obj.setStatus(((String) row.get("STATUS")));
            roomPoList.add(obj);
        }
        return roomPoList;
    }

    @Override
    public BookingInfoDo getBookingInfoByPaymentKey(String paymentKey) {
        String sql = "SELECT TP.PAYMENT_SEQ\n" +
                "        , TR.ROOM_NAME\n" +
                "        , TR.ROOM_PRICE\n" +
                "        , MIN( STR_TO_DATE(TB.BOOK_DATE, '%Y%m%d') ) AS BOOK_START_DATE\n" +
                "        , MAX( STR_TO_DATE(TB.BOOK_DATE, '%Y%m%d') ) AS BOOK_END_DATE\n" +
                "        , TP.PAYMENT_KEY\n" +
                "        , TP.RECEIVE_WALLET\n" +
                "        , TP.TOTAL_AMOUNT\n" +
                "        , TP.STATUS\n" +
                "        FROM TB_PAYMENT AS TP\n" +
                "        JOIN TB_BOOKING AS TB ON TP.PAYMENT_KEY = TB.PAYMENT_KEY\n" +
                "        JOIN TB_ROOM AS TR ON TB.ROOM_SEQ = TR.ROOM_SEQ\n" +
                "        WHERE TP.PAYMENT_KEY=?\n" +
                "        GROUP BY TP.PAYMENT_SEQ;";
        BookingInfoDo bookingInfoDo = (BookingInfoDo) jdbcTemplate.queryForObject(sql, new BookingInfoDoRowMapper(), new Object[]{paymentKey});
        return bookingInfoDo;
    }

    @Override
    public void updatePaymentStatusToPaid(String paymentKey) {

        //BigDecimal totalPrice = new BigDecimal(100);
        jdbcTemplate.update(
                "UPDATE TB_PAYMENT SET STATUS=\"?\" WHERE PAYMENT_KEY=?;",
                "PAID", paymentKey
        );

    }

}


