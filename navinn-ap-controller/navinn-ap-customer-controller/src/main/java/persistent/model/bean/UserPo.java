package persistent.model.bean;

import org.springframework.stereotype.Component;

@Component
public class UserPo {

    private String name;

    private String id;

    public String getComponentReg() {
        return componentReg;
    }

    public void setComponentReg(String componentReg) {
        this.componentReg = componentReg;
    }

    private String componentReg;


    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
