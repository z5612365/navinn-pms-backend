package persistent.model.bo;

import java.math.BigDecimal;

public class BookingInfoBo {

    private Integer paymentSeq;
    private String roomName;
    private BigDecimal roomPrice;
    private String bookStartDate;
    private String bookEndDate;
    private String paymentKey;
    private String receiveWallet;
    private BigDecimal totalAmount;
    private String status;

    public Integer getPaymentSeq() {
        return paymentSeq;
    }

    public void setPaymentSeq(Integer paymentSeq) {
        this.paymentSeq = paymentSeq;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public BigDecimal getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(BigDecimal roomPrice) {
        this.roomPrice = roomPrice;
    }

    public String getBookStartDate() {
        return bookStartDate;
    }

    public void setBookStartDate(String bookStartDate) {
        this.bookStartDate = bookStartDate;
    }

    public String getBookEndDate() {
        return bookEndDate;
    }

    public void setBookEndDate(String bookEndDate) {
        this.bookEndDate = bookEndDate;
    }

    public String getPaymentKey() {
        return paymentKey;
    }

    public void setPaymentKey(String paymentKey) {
        this.paymentKey = paymentKey;
    }

    public String getReceiveWallet() {
        return receiveWallet;
    }

    public void setReceiveWallet(String receiveWallet) {
        this.receiveWallet = receiveWallet;
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
