package com.qpp.comiccps.basics.entity;

public class Barrage {
    private String id;

    private String cartoonid;

    private String cartoonphotoid;

    private String cartoonsetid;

    private String contentdate;

    private String contentinfo;

    private String impldate;

    private Integer state;

    private String userid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCartoonid() {
        return cartoonid;
    }

    public void setCartoonid(String cartoonid) {
        this.cartoonid = cartoonid == null ? null : cartoonid.trim();
    }

    public String getCartoonphotoid() {
        return cartoonphotoid;
    }

    public void setCartoonphotoid(String cartoonphotoid) {
        this.cartoonphotoid = cartoonphotoid == null ? null : cartoonphotoid.trim();
    }

    public String getCartoonsetid() {
        return cartoonsetid;
    }

    public void setCartoonsetid(String cartoonsetid) {
        this.cartoonsetid = cartoonsetid == null ? null : cartoonsetid.trim();
    }

    public String getContentdate() {
        return contentdate;
    }

    public void setContentdate(String contentdate) {
        this.contentdate = contentdate == null ? null : contentdate.trim();
    }

    public String getContentinfo() {
        return contentinfo;
    }

    public void setContentinfo(String contentinfo) {
        this.contentinfo = contentinfo == null ? null : contentinfo.trim();
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

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }
}