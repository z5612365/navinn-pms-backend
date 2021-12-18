package persistent.model.mapper;

import org.springframework.jdbc.core.RowMapper;
import persistent.model.bean.BookingInfoDo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookingInfoDoRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {

        BookingInfoDo obj = new BookingInfoDo();

        obj.setPaymentSeq(resultSet.getInt("PAYMENT_SEQ"));
        obj.setRoomName(resultSet.getString("ROOM_NAME"));
        obj.setRoomPrice(resultSet.getBigDecimal("ROOM_PRICE"));
        obj.setBookStartDate(resultSet.getString("BOOK_START_DATE"));
        obj.setBookEndDate(resultSet.getString("BOOK_END_DATE"));
        obj.setPaymentKey(resultSet.getString("PAYMENT_KEY"));
        obj.setReceiveWallet(resultSet.getString("RECEIVE_WALLET"));
        obj.setTotalAmount(resultSet.getBigDecimal("TOTAL_AMOUNT"));
        obj.setStatus(resultSet.getString("STATUS"));

        return obj;

    }

}