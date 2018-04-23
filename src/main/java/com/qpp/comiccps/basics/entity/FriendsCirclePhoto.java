package com.qpp.comiccps.basics.entity;

public class FriendsCirclePhoto {
    private String id;

    private String friendcircleid;

    private String high;

    private String impldate;

    private String src;

    private String userid;

    private String width;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getFriendcircleid() {
        return friendcircleid;
    }

    public void setFriendcircleid(String friendcircleid) {
        this.friendcircleid = friendcircleid == null ? null : friendcircleid.trim();
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high == null ? null : high.trim();
    }

    public String getImpldate() {
        return impldate;
    }

    public void setImpldate(String impldate) {
        this.impldate = impldate == null ? null : impldate.trim();
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src == null ? null : src.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width == null ? null : width.trim();
    }
}