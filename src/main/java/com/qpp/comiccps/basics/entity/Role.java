package com.qpp.comiccps.basics.entity;

public class Role {
    private String id;

    private String escription;

    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getEscription() {
        return escription;
    }

    public void setEscription(String escription) {
        this.escription = escription == null ? null : escription.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}