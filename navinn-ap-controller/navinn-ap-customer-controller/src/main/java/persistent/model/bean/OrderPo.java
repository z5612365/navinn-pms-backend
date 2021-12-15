package persistent.model.bean;

/**
 * 訂單類
 *
 */
//@Component
public class OrderPo {
    /**
     * 訂單名稱
     */
    //@Value("1")
    private String orderName;
    /*
     * 使用者姓名
     */
    //@Value("2")
    private String userName;
    /**
     * 使用者物件
     */
    //@Value("#{userTT}")
    private UserPo customer;

    /*
    @PostConstruct
    public void init() {
        customer = new UserPo();
        customer.setComponentReg("111");
        customer.setId("222");
        customer.setName("333");
    }

*/

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

}