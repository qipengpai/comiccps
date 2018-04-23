package com.qpp.comiccps.basics.entity;

public class CartoonType {
    private String id;

    private String cartoontype;

    private String click;

    private Integer shownum;

    private Integer sort;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCartoontype() {
        return cartoontype;
    }

    public void setCartoontype(String cartoontype) {
        this.cartoontype = cartoontype == null ? null : cartoontype.trim();
    }

    public String getClick() {
        return click;
    }

    public void setClick(String click) {
        this.click = click == null ? null : click.trim();
    }

    public Integer getShownum() {
        return shownum;
    }

    public void setShownum(Integer shownum) {
        this.shownum = shownum;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}