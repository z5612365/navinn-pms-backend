package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import persistent.dao.A01DataAccessor;
import persistent.model.bean.BookingInfoDo;
import persistent.model.bean.PaymentPo;
import persistent.model.bean.RoomPo;
import persistent.model.bo.BookingInfoBo;
import persistent.model.bo.OrderBo;
import persistent.model.bean.OrderPo;
import persistent.model.bo.PaymentBo;
import persistent.model.bo.RoomBo;
import service.A01Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class A01ServiceImpl implements A01Service {
    @Autowired
    private OrderBo orderBo;

    @Autowired
    private A01DataAccessor a01DataAccessor;

    public void setA01DataAccessor(A01DataAccessor a01DataAccessor) {
        this.a01DataAccessor = a01DataAccessor;
    }

    @Override
    public OrderBo getOrderInfo() {
        OrderPo orderPo = a01DataAccessor.getOrderInfo();
        orderBo.setCustomer(orderPo.getCustomer());
        orderBo.setOrderName(orderPo.getOrderName());
        orderBo.setUserName(orderPo.getUserName());

        a01DataAccessor.getRoomInfo();
        return orderBo;
    }

    @Override
    public List<RoomBo> getRoomInfo() {
        List<RoomPo> roomPoList = a01DataAccessor.getRoomInfo();
        List<RoomBo> roomBoList = new ArrayList<>();
        for (RoomPo roomPo : roomPoList) {
            RoomBo obj = new RoomBo();
            obj.setRoomSeq(roomPo.getRoomSeq());
            obj.setRoomName(roomPo.getRoomName());
            obj.setRoomUrl(roomPo.getRoomUrl());
            obj.setRoomAlt(roomPo.getRoomAlt());
            obj.setRoomDesc(roomPo.getRoomDesc());
            obj.setRoomSpec(roomPo.getRoomSpec());
            obj.setRoomPrice(roomPo.getRoomPrice());
            roomBoList.add(obj);
        }
        return roomBoList;
    }

    @Override
    public RoomBo getRoomInfoByRoomSeq(String roomSeq) {

        RoomPo roomPo = a01DataAccessor.getRoomInfoByRoomSeq(roomSeq);

        RoomBo obj = new RoomBo();
        obj.setRoomSeq(roomPo.getRoomSeq());
        obj.setRoomName(roomPo.getRoomName());
        obj.setRoomUrl(roomPo.getRoomUrl());
        obj.setRoomAlt(roomPo.getRoomAlt());
        obj.setRoomDesc(roomPo.getRoomDesc());
        obj.setRoomSpec(roomPo.getRoomSpec());
        obj.setRoomPrice(roomPo.getRoomPrice());

        return obj;
    }

    @Override
    public String booking(String roomSeq, String bookingStartDate, String bookingEndDate) {

        LocalDate start = LocalDate.parse(bookingStartDate);
        LocalDate end = LocalDate.parse(bookingEndDate);
        List<String> bookDateList = new ArrayList<>();
        while (!start.isAfter(end)) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
            String formattedString = start.format(formatter);
            bookDateList.add(formattedString);
            start = start.plusDays(1);
        }
        System.out.println(bookDateList);
        String paymentKey = a01DataAccessor.booking(roomSeq, bookDateList);
        return paymentKey;
        //return null;
    }

    @Override
    public List<String> getBookedDate(String roomSeq) {
        List<String> bookedDateList = a01DataAccessor.getBookedDate(roomSeq);
        List<String> bookedDateListAddDash = new ArrayList<>();
        for (String bookedDate : bookedDateList) {
            bookedDateListAddDash.add(bookedDate.substring(0, 4) + "-" + bookedDate.substring(4, 6) + "-" + bookedDate.substring(6, 8));
        }
        return bookedDateListAddDash;
    }

    @Override
    public List<PaymentBo> getPaymentHistory() {

        List<PaymentPo> paymentDoList = a01DataAccessor.getPaymentHistory();
        List<PaymentBo> paymentBoList = new ArrayList<>();
        for (PaymentPo paymentPo : paymentDoList) {
            PaymentBo obj = new PaymentBo();
            obj.setPaymentKey(paymentPo.getPaymentKey());
            obj.setReceiveWallet(paymentPo.getReceiveWallet());
            obj.setTotalAmount(paymentPo.getTotalAmount());
            obj.setStatus(paymentPo.getStatus());

            paymentBoList.add(obj);
        }
        return paymentBoList;
    }

    @Override
    public BookingInfoBo getBookingInfoByPaymentKey(String paymentKey) {

        BookingInfoDo bookingInfoDo = a01DataAccessor.getBookingInfoByPaymentKey(paymentKey);

        BookingInfoBo obj = new BookingInfoBo();

        obj.setPaymentSeq(bookingInfoDo.getPaymentSeq());
        obj.setRoomName(bookingInfoDo.getRoomName());
        obj.setRoomPrice(bookingInfoDo.getRoomPrice());
        obj.setBookStartDate(bookingInfoDo.getBookStartDate());
        obj.setBookEndDate(bookingInfoDo.getBookEndDate());
        obj.setPaymentKey(bookingInfoDo.getPaymentKey());
        obj.setReceiveWallet(bookingInfoDo.getReceiveWallet());
        obj.setTotalAmount(bookingInfoDo.getTotalAmount());
        obj.setStatus(bookingInfoDo.getStatus());

        return obj;
    }

    @Override
    public void updatePaymentStatusToPaid(String paymentKey) {
        a01DataAccessor.updatePaymentStatusToPaid(paymentKey);
    };

}
