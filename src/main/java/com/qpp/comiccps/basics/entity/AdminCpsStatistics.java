package com.qpp.comiccps.basics.entity;

public class AdminCpsStatistics {
    private Integer id;

    private String uid;

    private String username;

    private Integer monthrunwater;

    private Double monthprofit;

    private Integer cpsnum;

    private Integer cpsrunwater;

    private Double cpsprofitsum;

    private Double allrecharge;

    private Double overrecharge;

    private Double balance;

    private String impldate;

    private Integer state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Integer getMonthrunwater() {
        return monthrunwater;
    }

    public void setMonthrunwater(Integer monthrunwater) {
        this.monthrunwater = monthrunwater;
    }

    public Double getMonthprofit() {
        return monthprofit;
    }

    public void setMonthprofit(Double monthprofit) {
        this.monthprofit = monthprofit;
    }

    public Integer getCpsnum() {
        return cpsnum;
    }

    public void setCpsnum(Integer cpsnum) {
        this.cpsnum = cpsnum;
    }

    public Integer getCpsrunwater() {
        return cpsrunwater;
    }

    public void setCpsrunwater(Integer cpsrunwater) {
        this.cpsrunwater = cpsrunwater;
    }

    public Double getCpsprofitsum() {
        return cpsprofitsum;
    }

    public void setCpsprofitsum(Double cpsprofitsum) {
        this.cpsprofitsum = cpsprofitsum;
    }

    public Double getAllrecharge() {
        return allrecharge;
    }

    public void setAllrecharge(Double allrecharge) {
        this.allrecharge = allrecharge;
    }

    public Double getOverrecharge() {
        return overrecharge;
    }

    public void setOverrecharge(Double overrecharge) {
        this.overrecharge = overrecharge;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getImpldate() {
        return impldate;
    }

    public void setImpldate(String impldate) {
        this.impldate = impldate == null ? null : impldate.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}