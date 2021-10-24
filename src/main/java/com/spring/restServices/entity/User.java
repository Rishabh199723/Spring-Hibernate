package com.spring.restServices.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "user_info", indexes = {@Index(name = "roll_name",columnList = "rollNo, name")})
//@IdClass(UserComposite.class)
//second level cache----------------
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    Long rollNo;
    String name;
    @OneToMany( mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
            @JsonIgnore
    List<Laptop> laptops;

    public Long getId() {
        return id;
    }
    public User() {}
    public User(Long id, Long rollNo, String name, List<Laptop> laptops) {
        this.id = id;
        this.rollNo = rollNo;
        this.name = name;
        this.laptops = laptops;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRollNo() {
        return rollNo;
    }

    public void setRollNo(Long rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
    }


}
