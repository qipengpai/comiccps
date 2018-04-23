package com.qpp.comiccps.basics.entity;

public class DistributorUserStatistics {
    private String id;

    private String distridutionid;

    private Integer manuser;

    private Integer newuser;

    private Integer nouser;

    private Integer payuser;

    private String statisticsdate;

    private Integer womanuser;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getDistridutionid() {
        return distridutionid;
    }

    public void setDistridutionid(String distridutionid) {
        this.distridutionid = distridutionid == null ? null : distridutionid.trim();
    }

    public Integer getManuser() {
        return manuser;
    }

    public void setManuser(Integer manuser) {
        this.manuser = manuser;
    }

    public Integer getNewuser() {
        return newuser;
    }

    public void setNewuser(Integer newuser) {
        this.newuser = newuser;
    }

    public Integer getNouser() {
        return nouser;
    }

    public void setNouser(Integer nouser) {
        this.nouser = nouser;
    }

    public Integer getPayuser() {
        return payuser;
    }

    public void setPayuser(Integer payuser) {
        this.payuser = payuser;
    }

    public String getStatisticsdate() {
        return statisticsdate;
    }

    public void setStatisticsdate(String statisticsdate) {
        this.statisticsdate = statisticsdate == null ? null : statisticsdate.trim();
    }

    public Integer getWomanuser() {
        return womanuser;
    }

    public void setWomanuser(Integer womanuser) {
        this.womanuser = womanuser;
    }
}