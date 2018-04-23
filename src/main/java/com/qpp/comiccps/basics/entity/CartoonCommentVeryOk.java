package com.qpp.comiccps.basics.entity;

public class CartoonCommentVeryOk {
    private String id;

    private String cartooncommentid;

    private String okdate;

    private Integer okstate;

    private String userid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCartooncommentid() {
        return cartooncommentid;
    }

    public void setCartooncommentid(String cartooncommentid) {
        this.cartooncommentid = cartooncommentid == null ? null : cartooncommentid.trim();
    }

    public String getOkdate() {
        return okdate;
    }

    public void setOkdate(String okdate) {
        this.okdate = okdate == null ? null : okdate.trim();
    }

    public Integer getOkstate() {
        return okstate;
    }

    public void setOkstate(Integer okstate) {
        this.okstate = okstate;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }
}