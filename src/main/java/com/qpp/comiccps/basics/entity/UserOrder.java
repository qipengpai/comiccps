package com.qpp.comiccps.basics.entity;

public class UserOrder {
    private String id;

    private Integer ordercurrency;

    private String orderdate;

    private String orderdescription;

    private String orderimpldate;

    private String orderintegral;

    private Integer ordermoney;

    private String ordernum;

    private String orderremarks;

    private Integer orderstate;

    private String orderuserid;

    private String mchcreateip;

    private String orderusername;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getOrdercurrency() {
        return ordercurrency;
    }

    public void setOrdercurrency(Integer ordercurrency) {
        this.ordercurrency = ordercurrency;
    }

    public String getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(String orderdate) {
        this.orderdate = orderdate == null ? null : orderdate.trim();
    }

    public String getOrderdescription() {
        return orderdescription;
    }

    public void setOrderdescription(String orderdescription) {
        this.orderdescription = orderdescription == null ? null : orderdescription.trim();
    }

    public String getOrderimpldate() {
        return orderimpldate;
    }

    public void setOrderimpldate(String orderimpldate) {
        this.orderimpldate = orderimpldate == null ? null : orderimpldate.trim();
    }

    public String getOrderintegral() {
        return orderintegral;
    }

    public void setOrderintegral(String orderintegral) {
        this.orderintegral = orderintegral == null ? null : orderintegral.trim();
    }

    public Integer getOrdermoney() {
        return ordermoney;
    }

    public void setOrdermoney(Integer ordermoney) {
        this.ordermoney = ordermoney;
    }

    public String getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(String ordernum) {
        this.ordernum = ordernum == null ? null : ordernum.trim();
    }

    public String getOrderremarks() {
        return orderremarks;
    }

    public void setOrderremarks(String orderremarks) {
        this.orderremarks = orderremarks == null ? null : orderremarks.trim();
    }

    public Integer getOrderstate() {
        return orderstate;
    }

    public void setOrderstate(Integer orderstate) {
        this.orderstate = orderstate;
    }

    public String getOrderuserid() {
        return orderuserid;
    }

    public void setOrderuserid(String orderuserid) {
        this.orderuserid = orderuserid == null ? null : orderuserid.trim();
    }

    public String getMchcreateip() {
        return mchcreateip;
    }

    public void setMchcreateip(String mchcreateip) {
        this.mchcreateip = mchcreateip == null ? null : mchcreateip.trim();
    }

    public String getOrderusername() {
        return orderusername;
    }

    public void setOrderusername(String orderusername) {
        this.orderusername = orderusername == null ? null : orderusername.trim();
    }
}