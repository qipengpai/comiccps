package com.qpp.comiccps.basics.entity;

public class CartoonComment {
    private String id;

    private String aite;

    private String cartoonid;

    private Integer commentcount;

    private String commentdate;

    private String commentid;

    private String commentinfo;

    private Integer deletecartooncomment;

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

    public String getCartoonid() {
        return cartoonid;
    }

    public void setCartoonid(String cartoonid) {
        this.cartoonid = cartoonid == null ? null : cartoonid.trim();
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

    public String getCommentid() {
        return commentid;
    }

    public void setCommentid(String commentid) {
        this.commentid = commentid == null ? null : commentid.trim();
    }

    public String getCommentinfo() {
        return commentinfo;
    }

    public void setCommentinfo(String commentinfo) {
        this.commentinfo = commentinfo == null ? null : commentinfo.trim();
    }

    public Integer getDeletecartooncomment() {
        return deletecartooncomment;
    }

    public void setDeletecartooncomment(Integer deletecartooncomment) {
        this.deletecartooncomment = deletecartooncomment;
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