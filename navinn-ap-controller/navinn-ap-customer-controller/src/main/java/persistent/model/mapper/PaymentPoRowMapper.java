package persistent.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import persistent.model.bean.PaymentPo;

public class PaymentPoRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {

        PaymentPo obj = new PaymentPo();
        obj.setRoomSeq(resultSet.getString("ROOM_SEQ"));
        obj.setPaymentKey(resultSet.getString("PAYMENT_KEY"));
        obj.setRoomName(resultSet.getString("ROOM_NAME"));
        obj.setTotalAmount(resultSet.getBigDecimal("TOTAL_AMOUNT"));
        obj.setStatus(resultSet.getString("STATUS"));

        return obj;

    }

}