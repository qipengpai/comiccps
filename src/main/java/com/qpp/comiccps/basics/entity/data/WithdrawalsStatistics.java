package com.qpp.comiccps.basics.entity.data;

public class WithdrawalsStatistics {

    private String username; //名字
    private double proportion; //分成比例
    private double money;  //钱数

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getProportion() {
        return proportion;
    }

    public void setProportion(double proportion) {
        this.proportion = proportion;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
