package com.qpp.comiccps.basics.entity;

public class DistributorOrderTotal {
    private String id;

    private String distridutionid;

    private String impldate;

    private Integer noordinaryrechargenum;

    private Integer noviprechargenum;

    private Double ordinarycompletionrate;

    private Double ordinaryrecharge;

    private Integer ordinaryrechargenum;

    private Double percapitarecharge;

    private Double recharge;

    private Integer rechargepersonnum;

    private Integer totaltype;

    private Double vipcompletionrate;

    private Double viprecharge;

    private Integer viprechargenum;

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

    public String getImpldate() {
        return impldate;
    }

    public void setImpldate(String impldate) {
        this.impldate = impldate == null ? null : impldate.trim();
    }

    public Integer getNoordinaryrechargenum() {
        return noordinaryrechargenum;
    }

    public void setNoordinaryrechargenum(Integer noordinaryrechargenum) {
        this.noordinaryrechargenum = noordinaryrechargenum;
    }

    public Integer getNoviprechargenum() {
        return noviprechargenum;
    }

    public void setNoviprechargenum(Integer noviprechargenum) {
        this.noviprechargenum = noviprechargenum;
    }

    public Double getOrdinarycompletionrate() {
        return ordinarycompletionrate;
    }

    public void setOrdinarycompletionrate(Double ordinarycompletionrate) {
        this.ordinarycompletionrate = ordinarycompletionrate;
    }

    public Double getOrdinaryrecharge() {
        return ordinaryrecharge;
    }

    public void setOrdinaryrecharge(Double ordinaryrecharge) {
        this.ordinaryrecharge = ordinaryrecharge;
    }

    public Integer getOrdinaryrechargenum() {
        return ordinaryrechargenum;
    }

    public void setOrdinaryrechargenum(Integer ordinaryrechargenum) {
        this.ordinaryrechargenum = ordinaryrechargenum;
    }

    public Double getPercapitarecharge() {
        return percapitarecharge;
    }

    public void setPercapitarecharge(Double percapitarecharge) {
        this.percapitarecharge = percapitarecharge;
    }

    public Double getRecharge() {
        return recharge;
    }

    public void setRecharge(Double recharge) {
        this.recharge = recharge;
    }

    public Integer getRechargepersonnum() {
        return rechargepersonnum;
    }

    public void setRechargepersonnum(Integer rechargepersonnum) {
        this.rechargepersonnum = rechargepersonnum;
    }

    public Integer getTotaltype() {
        return totaltype;
    }

    public void setTotaltype(Integer totaltype) {
        this.totaltype = totaltype;
    }

    public Double getVipcompletionrate() {
        return vipcompletionrate;
    }

    public void setVipcompletionrate(Double vipcompletionrate) {
        this.vipcompletionrate = vipcompletionrate;
    }

    public Double getViprecharge() {
        return viprecharge;
    }

    public void setViprecharge(Double viprecharge) {
        this.viprecharge = viprecharge;
    }

    public Integer getViprechargenum() {
        return viprechargenum;
    }

    public void setViprechargenum(Integer viprechargenum) {
        this.viprechargenum = viprechargenum;
    }
}