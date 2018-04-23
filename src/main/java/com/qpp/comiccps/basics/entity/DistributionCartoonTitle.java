package com.qpp.comiccps.basics.entity;

public class DistributionCartoonTitle {
    private String id;

    private String cartoonid;

    private String cartoontitle;

    private String impldate;

    private Integer sort;

    private Integer state;

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

    public String getCartoontitle() {
        return cartoontitle;
    }

    public void setCartoontitle(String cartoontitle) {
        this.cartoontitle = cartoontitle == null ? null : cartoontitle.trim();
    }

    public String getImpldate() {
        return impldate;
    }

    public void setImpldate(String impldate) {
        this.impldate = impldate == null ? null : impldate.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}