package persistent.model.bo;

import persistent.model.bean.UserPo;

/**
 * 訂單類
 *
 */

public class OrderBo {
    /**
     * 訂單名稱
     */
    private String orderName;
    /*
     * 使用者姓名
     */
    private String userName;
    /**
     * 使用者物件
     */
    private UserPo customer;

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public UserPo getCustomer() {
        return customer;
    }

    public void setCustomer(UserPo customer) {
        this.customer = customer;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    @Override
    public String toString() {
        return "訂單名："+this.getOrderName()+",姓名："+this.getUserName()+",編號："+this.getCustomer().getId();
    }
}