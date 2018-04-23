package com.qpp.comiccps.basics.entity;

public class Distributor {
    private String id;

    private String accountname;

    private String accountnum;

    private Double allrecharge;

    private Double balance;

    private String email;

    private String headimg;

    private String impldate;

    private String lastlogindate;

    private String nickname;

    private Double overrecharge;

    private String paytype;

    private String phone;

    private Double proportion;

    private String qd;

    private Integer state;

    private String username;

    private String userpwd;

    private String usertype;

    private Integer withdrawalstype;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getAccountname() {
        return accountname;
    }

    public void setAccountname(String accountname) {
        this.accountname = accountname == null ? null : accountname.trim();
    }

    public String getAccountnum() {
        return accountnum;
    }

    public void setAccountnum(String accountnum) {
        this.accountnum = accountnum == null ? null : accountnum.trim();
    }

    public Double getAllrecharge() {
        return allrecharge;
    }

    public void setAllrecharge(Double allrecharge) {
        this.allrecharge = allrecharge;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getHeadimg() {
        return headimg;
    }

    public void setHeadimg(String headimg) {
        this.headimg = headimg == null ? null : headimg.trim();
    }

    public String getImpldate() {
        return impldate;
    }

    public void setImpldate(String impldate) {
        this.impldate = impldate == null ? null : impldate.trim();
    }

    public String getLastlogindate() {
        return lastlogindate;
    }

    public void setLastlogindate(String lastlogindate) {
        this.lastlogindate = lastlogindate == null ? null : lastlogindate.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public Double getOverrecharge() {
        return overrecharge;
    }

    public void setOverrecharge(Double overrecharge) {
        this.overrecharge = overrecharge;
    }

    public String getPaytype() {
        return paytype;
    }

    public void setPaytype(String paytype) {
        this.paytype = paytype == null ? null : paytype.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Double getProportion() {
        return proportion;
    }

    public void setProportion(Double proportion) {
        this.proportion = proportion;
    }

    public String getQd() {
        return qd;
    }

    public void setQd(String qd) {
        this.qd = qd == null ? null : qd.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd == null ? null : userpwd.trim();
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype == null ? null : usertype.trim();
    }

    public Integer getWithdrawalstype() {
        return withdrawalstype;
    }

    public void setWithdrawalstype(Integer withdrawalstype) {
        this.withdrawalstype = withdrawalstype;
    }
}