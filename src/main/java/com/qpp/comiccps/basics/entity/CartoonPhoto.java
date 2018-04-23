package com.qpp.comiccps.basics.entity;

public class CartoonPhoto {
    private String id;

    private String cartoonid;

    private String cartoonsetid;

    private String impldate;

    private String photoheight;

    private String photourl;

    private String photowidth;

    private Integer sort;

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

    public String getCartoonsetid() {
        return cartoonsetid;
    }

    public void setCartoonsetid(String cartoonsetid) {
        this.cartoonsetid = cartoonsetid == null ? null : cartoonsetid.trim();
    }

    public String getImpldate() {
        return impldate;
    }

    public void setImpldate(String impldate) {
        this.impldate = impldate == null ? null : impldate.trim();
    }

    public String getPhotoheight() {
        return photoheight;
    }

    public void setPhotoheight(String photoheight) {
        this.photoheight = photoheight == null ? null : photoheight.trim();
    }

    public String getPhotourl() {
        return photourl;
    }

    public void setPhotourl(String photourl) {
        this.photourl = photourl == null ? null : photourl.trim();
    }

    public String getPhotowidth() {
        return photowidth;
    }

    public void setPhotowidth(String photowidth) {
        this.photowidth = photowidth == null ? null : photowidth.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}