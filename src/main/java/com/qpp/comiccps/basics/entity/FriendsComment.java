package com.qpp.comiccps.basics.entity;

public class FriendsComment {
    private String id;

    private String aite;

    private Integer commentcount;

    private String commentdate;

    private String commentinfo;

    private String friendcircleid;

    private String impldate;

    private Integer okcount;

    private Integer sort;

    private String userid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getAite() {
        return aite;
    }

    public void setAite(String aite) {
        this.aite = aite == null ? null : aite.trim();
    }

    public Integer getCommentcount() {
        return commentcount;
    }

    public void setCommentcount(Integer commentcount) {
        this.commentcount = commentcount;
    }

    public String getCommentdate() {
        return commentdate;
    }

    public void setCommentdate(String commentdate) {
        this.commentdate = commentdate == null ? null : commentdate.trim();
    }

    public String getCommentinfo() {
        return commentinfo;
    }

    public void setCommentinfo(String commentinfo) {
        this.commentinfo = commentinfo == null ? null : commentinfo.trim();
    }

    public String getFriendcircleid() {
        return friendcircleid;
    }

    public void setFriendcircleid(String friendcircleid) {
        this.friendcircleid = friendcircleid == null ? null : friendcircleid.trim();
    }

    public String getImpldate() {
        return impldate;
    }

    public void setImpldate(String impldate) {
        this.impldate = impldate == null ? null : impldate.trim();
    }

    public Integer getOkcount() {
        return okcount;
    }

    public void setOkcount(Integer okcount) {
        this.okcount = okcount;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }
}