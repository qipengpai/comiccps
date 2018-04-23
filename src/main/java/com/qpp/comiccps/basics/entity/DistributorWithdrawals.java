package com.qpp.comiccps.basics.entity;

public class DistributorWithdrawals {
    private String id;

    private String distridutionid;

    private String impldate;

    private Double proportion;

    private String remarks;

    private String withdrawalsdate;

    private Double withdrawalsmoney;

    private Integer withdrawalsstate;

    private Integer ordersum;

    private Double todayrecharge;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getDistridutionid() {
        return distridutionid;
    }

    public void setDistridutionid(String distridutionid) {
        this.distridutionid = distridutionid == null ? null : distridutionid.trim();
    }

    public String getImpldate() {
        return impldate;
    }

    public void setImpldate(String impldate) {
        this.impldate = impldate == null ? null : impldate.trim();
    }

    public Double getProportion() {
        return proportion;
    }

    public void setProportion(Double proportion) {
        this.proportion = proportion;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getWithdrawalsdate() {
        return withdrawalsdate;
    }

    public void setWithdrawalsdate(String withdrawalsdate) {
        this.withdrawalsdate = withdrawalsdate == null ? null : withdrawalsdate.trim();
    }

    public Double getWithdrawalsmoney() {
        return withdrawalsmoney;
    }

    public void setWithdrawalsmoney(Double withdrawalsmoney) {
        this.withdrawalsmoney = withdrawalsmoney;
    }

    public Integer getWithdrawalsstate() {
        return withdrawalsstate;
    }

    public void setWithdrawalsstate(Integer withdrawalsstate) {
        this.withdrawalsstate = withdrawalsstate;
    }

    public Integer getOrdersum() {
        return ordersum;
    }

    public void setOrdersum(Integer ordersum) {
        this.ordersum = ordersum;
    }

    public Double getTodayrecharge() {
        return todayrecharge;
    }

    public void setTodayrecharge(Double todayrecharge) {
        this.todayrecharge = todayrecharge;
    }
}