package controller;

import logger.HrsLogger;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import persistent.model.bo.PaymentBo;
import persistent.model.bo.RoomBo;
import service.A01Service;

import java.util.List;

@RestController("/")
@CrossOrigin()
public class A01Controller {

    HrsLogger logger = HrsLogger.create(A01Controller.class);

    @Autowired
    private A01Service a01Service;

    public void setA01Service(A01Service a01Service) {
        this.a01Service = a01Service;
    }

    @RequestMapping("/")
    public String home() {
        logger.fatal("FATAL");// 層級1 FATAL的動作
        logger.error("error");// 層級2 error的動作
        logger.warn("warn");// 層級3 warn的動作
        logger.info("info");// 層級4 info 類似做show的動作
        logger.debug("debug");// 層級5 做debug的動作

        //丟入變數測試
        String aa = "good";
        logger.info("info:" + aa);//

        return a01Service.getOrderInfo().toString();
    }

    @RequestMapping(value = "/getRoomInfo")
    public List<RoomBo> getRoomInfo() {
        return a01Service.getRoomInfo();
    }

    @RequestMapping(value = "getRoomInfoByRoomSeq")
    public RoomBo getRoomInfoByRoomSeq(@RequestParam("roomSeq") String roomSeq) {
        return a01Service.getRoomInfoByRoomSeq(roomSeq);
    }

    @RequestMapping(value = "booking")
    public String getRoomInfoByRoomSeq(@RequestParam("roomSeq") String roomSeq, @RequestParam("bookingStartDate") String bookingStartDate, @RequestParam("bookingEndDate") String bookingEndDate) {
        return a01Service.booking(roomSeq, bookingStartDate, bookingEndDate);
    }

    @RequestMapping(value = "/getBookedDate")
    public List<String> getBookedDate(@RequestParam("roomSeq") String roomSeq) {
        return a01Service.getBookedDate(roomSeq);
    }

    @RequestMapping(value = "/getPaymentHistory")
    public List<PaymentBo> getPaymentHistory() {
        return a01Service.getPaymentHistory();
    }

}
