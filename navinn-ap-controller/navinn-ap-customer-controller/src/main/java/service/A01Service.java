package service;

import persistent.model.bean.BookingInfoDo;
import persistent.model.bo.BookingInfoBo;
import persistent.model.bo.OrderBo;
import persistent.model.bo.PaymentBo;
import persistent.model.bo.RoomBo;

import java.util.List;

public interface A01Service {
    public OrderBo getOrderInfo();

    public List<RoomBo> getRoomInfo();

    public RoomBo getRoomInfoByRoomSeq(String roomSeq);

    public String booking(String roomSeq, String bookingStartDate, String bookingEndDate);

    public List<String> getBookedDate(String roomSeq);

    public List<PaymentBo> getPaymentHistory();

    public BookingInfoBo getBookingInfoByPaymentKey(String paymentKey);

    public void updatePaymentStatusToPaid(String paymentKey);
}
