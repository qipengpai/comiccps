package com.qpp.comiccps.basics.entity;

public class CartoonSet {
    private String id;

    private String barragecount;

    private Integer buycount;

    private String cartoonid;

    private Integer commentcount;

    private String details;

    private String impldate;

    private Integer moneystate;

    private Integer okcount;

    private Integer playcount;

    private Integer price;

    private String showphoto;

    private Integer sort;

    private String titile;

    private String updatedate;

    private String updatetitile;

    private Integer vip;

    private Integer watchstate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getBarragecount() {
        return barragecount;
    }

    public void setBarragecount(String barragecount) {
        this.barragecount = barragecount == null ? null : barragecount.trim();
    }

    public Integer getBuycount() {
        return buycount;
    }

    public void setBuycount(Integer buycount) {
        this.buycount = buycount;
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

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details == null ? null : details.trim();
    }

    public String getImpldate() {
        return impldate;
    }

    public void setImpldate(String impldate) {
        this.impldate = impldate == null ? null : impldate.trim();
    }

    public Integer getMoneystate() {
        return moneystate;
    }

    public void setMoneystate(Integer moneystate) {
        this.moneystate = moneystate;
    }

    public Integer getOkcount() {
        return okcount;
    }

    public void setOkcount(Integer okcount) {
        this.okcount = okcount;
    }

    public Integer getPlaycount() {
        return playcount;
    }

    public void setPlaycount(Integer playcount) {
        this.playcount = playcount;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getShowphoto() {
        return showphoto;
    }

    public void setShowphoto(String showphoto) {
        this.showphoto = showphoto == null ? null : showphoto.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getTitile() {
        return titile;
    }

    public void setTitile(String titile) {
        this.titile = titile == null ? null : titile.trim();
    }

    public String getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(String updatedate) {
        this.updatedate = updatedate == null ? null : updatedate.trim();
    }

    public String getUpdatetitile() {
        return updatetitile;
    }

    public void setUpdatetitile(String updatetitile) {
        this.updatetitile = updatetitile == null ? null : updatetitile.trim();
    }

    public Integer getVip() {
        return vip;
    }

    public void setVip(Integer vip) {
        this.vip = vip;
    }

    public Integer getWatchstate() {
        return watchstate;
    }

    public void setWatchstate(Integer watchstate) {
        this.watchstate = watchstate;
    }
}