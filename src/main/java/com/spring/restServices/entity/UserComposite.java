package com.spring.restServices.entity;

import java.io.Serializable;

public class UserComposite implements Serializable {
    Long id;
    Long rollNo;

    public UserComposite(Long id, Long rollNo) {
        this.id = id;
        this.rollNo = rollNo;
    }
    public UserComposite() {}
}
