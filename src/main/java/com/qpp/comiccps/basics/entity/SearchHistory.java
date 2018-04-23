package com.qpp.comiccps.basics.entity;

public class SearchHistory {
    private String id;

    private String impldate;

    private String conext;

    private String userid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getImpldate() {
        return impldate;
    }

    public void setImpldate(String impldate) {
        this.impldate = impldate == null ? null : impldate.trim();
    }

    public String getConext() {
        return conext;
    }

    public void setConext(String conext) {
        this.conext = conext == null ? null : conext.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }
}