package persistent.model.bo;

import java.math.BigDecimal;

public class PaymentBo {

    private String roomSeq;
    private String paymentKey;
    private String roomName;
    private BigDecimal totalAmount;
    private String status;

    public String getRoomSeq() {
        return roomSeq;
    }

    public void setRoomSeq(String roomSeq) {
        this.roomSeq = roomSeq;
    }

    public String getPaymentKey() {
        return paymentKey;
    }

    public void setPaymentKey(String paymentKey) {
        this.paymentKey = paymentKey;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}