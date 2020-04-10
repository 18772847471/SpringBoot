package scriptexception.model;

import java.math.BigDecimal;

public class Buyplan {
    private  String buyplanguid;
    private  Integer platform;
    private  BigDecimal money;

    public String getBuyplanguid() {
        return buyplanguid;
    }

    public void setBuyplanguid(String buyplanguid) {
        this.buyplanguid = buyplanguid;
    }

    public Integer getPlatform() {
        return platform;
    }

    public void setPlatform(Integer platform) {
        this.platform = platform;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}
