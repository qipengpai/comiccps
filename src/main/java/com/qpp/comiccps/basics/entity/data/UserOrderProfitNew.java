package com.qpp.comiccps.basics.entity.data;

public class UserOrderProfitNew {
    private String username; //名字
    private String qd; //渠道
    private Double money;  //钱数


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getQd() {
        return qd;
    }

    public void setQd(String qd) {
        this.qd = qd;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}
