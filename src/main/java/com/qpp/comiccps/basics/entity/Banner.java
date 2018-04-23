package com.qpp.comiccps.basics.entity;

public class Banner {
    private String id;

    private String cartoonid;

    private Integer click;

    private String comicurl;

    private String httpimg;

    private String impldate;

    private Integer state;

    private String title;

    private Integer anroidstate;

    private Integer iosstate;

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

    public Integer getClick() {
        return click;
    }

    public void setClick(Integer click) {
        this.click = click;
    }

    public String getComicurl() {
        return comicurl;
    }

    public void setComicurl(String comicurl) {
        this.comicurl = comicurl == null ? null : comicurl.trim();
    }

    public String getHttpimg() {
        return httpimg;
    }

    public void setHttpimg(String httpimg) {
        this.httpimg = httpimg == null ? null : httpimg.trim();
    }

    public String getImpldate() {
        return impldate;
    }

    public void setImpldate(String impldate) {
        this.impldate = impldate == null ? null : impldate.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getAnroidstate() {
        return anroidstate;
    }

    public void setAnroidstate(Integer anroidstate) {
        this.anroidstate = anroidstate;
    }

    public Integer getIosstate() {
        return iosstate;
    }

    public void setIosstate(Integer iosstate) {
        this.iosstate = iosstate;
    }
}