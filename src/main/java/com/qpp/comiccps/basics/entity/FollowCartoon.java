package com.qpp.comiccps.basics.entity;

public class FollowCartoon {
    private String id;

    private String cartoonid;

    private String followdate;

    private Integer updatestate;

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

    public String getFollowdate() {
        return followdate;
    }

    public void setFollowdate(String followdate) {
        this.followdate = followdate == null ? null : followdate.trim();
    }

    public Integer getUpdatestate() {
        return updatestate;
    }

    public void setUpdatestate(Integer updatestate) {
        this.updatestate = updatestate;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }
}