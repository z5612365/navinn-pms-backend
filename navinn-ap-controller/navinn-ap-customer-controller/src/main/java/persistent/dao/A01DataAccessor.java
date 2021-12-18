package persistent.dao;

import persistent.model.bean.BookingInfoDo;
import persistent.model.bean.OrderPo;
import persistent.model.bean.PaymentPo;
import persistent.model.bean.RoomPo;

import java.util.List;

public interface A01DataAccessor {
    public OrderPo getOrderInfo();

    public List<RoomPo> getRoomInfo();

    public RoomPo getRoomInfoByRoomSeq(String roomSeq);

    public String booking(String roomSeq, List<String> bookDateList);

    public List<String> getBookedDate(String roomSeq);

    public List<PaymentPo> getPaymentHistory();

    public BookingInfoDo getBookingInfoByPaymentKey(String paymentKey);

    public void updatePaymentStatusToPaid(String paymentKey);
}
