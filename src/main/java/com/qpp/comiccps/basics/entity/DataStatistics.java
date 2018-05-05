package com.qpp.comiccps.basics.entity;

public class DataStatistics {
    private String id;

    private Integer visternum;

    private Integer dailyvisteraddnum;

    private Integer svipuseraddnum;

    private Integer vipuseraddnum;

    private Integer paynum;

    private Integer paypersonnum;

    private Double arppu;

    private Double arpu;

    private Double aru;

    private String impldate;

    private Integer state;

    private Integer beanincome;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getVisternum() {
        return visternum;
    }

    public void setVisternum(Integer visternum) {
        this.visternum = visternum;
    }

    public Integer getDailyvisteraddnum() {
        return dailyvisteraddnum;
    }

    public void setDailyvisteraddnum(Integer dailyvisteraddnum) {
        this.dailyvisteraddnum = dailyvisteraddnum;
    }

    public Integer getSvipuseraddnum() {
        return svipuseraddnum;
    }

    public void setSvipuseraddnum(Integer svipuseraddnum) {
        this.svipuseraddnum = svipuseraddnum;
    }

    public Integer getVipuseraddnum() {
        return vipuseraddnum;
    }

    public void setVipuseraddnum(Integer vipuseraddnum) {
        this.vipuseraddnum = vipuseraddnum;
    }

    public Integer getPaynum() {
        return paynum;
    }

    public void setPaynum(Integer paynum) {
        this.paynum = paynum;
    }

    public Integer getPaypersonnum() {
        return paypersonnum;
    }

    public void setPaypersonnum(Integer paypersonnum) {
        this.paypersonnum = paypersonnum;
    }

    public Double getArppu() {
        return arppu;
    }

    public void setArppu(Double arppu) {
        this.arppu = arppu;
    }

    public Double getArpu() {
        return arpu;
    }

    public void setArpu(Double arpu) {
        this.arpu = arpu;
    }

    public Double getAru() {
        return aru;
    }

    public void setAru(Double aru) {
        this.aru = aru;
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

    public Integer getBeanincome() {
        return beanincome;
    }

    public void setBeanincome(Integer beanincome) {
        this.beanincome = beanincome;
    }
}