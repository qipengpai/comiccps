package com.qpp.comiccps.basics.entity;

public class FeedBack {
    private String id;

    private String backdate;

    private String content;

    private String impldaye;

    private String userid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getBackdate() {
        return backdate;
    }

    public void setBackdate(String backdate) {
        this.backdate = backdate == null ? null : backdate.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getImpldaye() {
        return impldaye;
    }

    public void setImpldaye(String impldaye) {
        this.impldaye = impldaye == null ? null : impldaye.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }
}