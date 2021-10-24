package com.spring.restServices.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long lid;
    private String modelNo;
    private String name;
    @ManyToOne
    @JsonIgnore
    private User user;
    public Laptop(){}
    public Laptop(Long lid, String modelNo, String name, User user) {
        this.lid = lid;
        this.modelNo = modelNo;
        this.name = name;
        this.user = user;
    }

    public Long getLid() {
        return lid;
    }

    public void setLid(Long lid) {
        this.lid = lid;
    }

    public String getModelNo() {
        return modelNo;
    }

    public void setModelNo(String modelNo) {
        this.modelNo = modelNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
