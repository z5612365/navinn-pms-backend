package persistent.model.bean;

import java.math.BigDecimal;

public class RoomPo {

    private String roomSeq;
    private String roomName;
    private String roomUrl;
    private String roomAlt;
    private String roomDesc;
    private String roomSpec;
    private BigDecimal roomPrice;

    public String getRoomSeq() {
        return roomSeq;
    }

    public void setRoomSeq(String roomSeq) {
        this.roomSeq = roomSeq;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomUrl() {
        return roomUrl;
    }

    public void setRoomUrl(String roomUrl) {
        this.roomUrl = roomUrl;
    }

    public String getRoomAlt() {
        return roomAlt;
    }

    public void setRoomAlt(String roomAlt) {
        this.roomAlt = roomAlt;
    }

    public String getRoomDesc() {
        return roomDesc;
    }

    public void setRoomDesc(String roomDesc) {
        this.roomDesc = roomDesc;
    }

    public String getRoomSpec() {
        return roomSpec;
    }

    public void setRoomSpec(String roomSpec) {
        this.roomSpec = roomSpec;
    }

    public BigDecimal getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(BigDecimal roomPrice) {
        this.roomPrice = roomPrice;
    }

}

