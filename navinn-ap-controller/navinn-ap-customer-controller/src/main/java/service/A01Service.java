package service;

import persistent.model.bo.OrderBo;
import persistent.model.bo.RoomBo;

import java.util.List;

public interface A01Service {
    public OrderBo getOrderInfo() ;
    public List<RoomBo> getRoomInfo();
    public RoomBo getRoomInfoByRoomSeq(String roomSeq);
    public String booking(String roomSeq, String bookingStartDate, String bookingEndDate);

}
