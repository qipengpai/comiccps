package com.qpp.comiccps.basics.entity;

public class AdminCpsStatisticsDay {
    private Integer id;

    private String uid;

    private String username;

    private Integer monthrunwater;

    private Double monthprofit;

    private Integer addcps;

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

    public Integer getAddcps() {
        return addcps;
    }

    public void setAddcps(Integer addcps) {
        this.addcps = addcps;
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