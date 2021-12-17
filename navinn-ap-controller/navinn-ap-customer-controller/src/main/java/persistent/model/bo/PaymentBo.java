
package persistent.model.bo;

import java.math.BigDecimal;

public class PaymentBo {

    private String paymentKey;
    private String receiveWallet;
    private String refundWallet;
    private BigDecimal totalAmount;
    private String status;

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

    public String getRefundWallet() {
        return refundWallet;
    }

    public void setRefundWallet(String refundWallet) {
        this.refundWallet = refundWallet;
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