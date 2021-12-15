package persistent.model.mapper;

import org.springframework.jdbc.core.RowMapper;
import persistent.model.bean.RoomPo;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoomPoRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {

        RoomPo obj = new RoomPo();

        obj.setRoomSeq(new Integer(resultSet.getInt("ROOM_SEQ")).toString());
        obj.setRoomName(resultSet.getString("ROOM_NAME"));
        obj.setRoomUrl(resultSet.getString("ROOM_URL"));
        obj.setRoomAlt(resultSet.getString("ROOM_ALT"));
        obj.setRoomDesc(resultSet.getString("ROOM_DESC"));
        obj.setRoomSpec(resultSet.getString("ROOM_SPEC"));
        obj.setRoomPrice(resultSet.getBigDecimal("ROOM_PRICE"));

        return obj;

    }

}
