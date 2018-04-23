package com.qpp.comiccps.basics.entity;

public class CartoonAllType {
    private String id;

    private String cartoonid;

    private String cartoontypeid;

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

    public String getCartoontypeid() {
        return cartoontypeid;
    }

    public void setCartoontypeid(String cartoontypeid) {
        this.cartoontypeid = cartoontypeid == null ? null : cartoontypeid.trim();
    }
}