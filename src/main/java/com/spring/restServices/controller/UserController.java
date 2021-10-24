package com.spring.restServices.controller;

import com.spring.restServices.entity.Laptop;
import com.spring.restServices.entity.User;
import com.spring.restServices.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
//@RequestMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.ALL_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    UserRepo repo;

    @PostMapping(value = "/addUserAndLaptop", consumes= MediaType.APPLICATION_JSON_VALUE)
    public String addUserAndLaptop() {
        User user = new User();
        user.setRollNo(1L);
        user.setName("Test");
        Laptop l1 = new Laptop();
        l1.setModelNo("MNO");
        l1.setName("HP");
        l1.setUser(user);
        Laptop l2 = new Laptop();
        l2.setModelNo("MNO");
        l2.setName("HP");
        l2.setUser(user);
        user.setLaptops(Arrays.asList(l1,l2));
        return repo.saveUser(user);
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        return repo.deleteUser(id);
    }

    @GetMapping(value = "/fetchLaptops/{id}", produces = {"application/json", "text/xml"})
    public ResponseEntity<List<Object[]>> fetchLaptops(@PathVariable("id") Long id) {
//        List<Laptop> laptops =  repo.fetchLaptops(id);
        List<Object[]> user = repo.fetchUserWithHQL(id);
        for (Object[] x: user)
        System.out.println(Arrays.toString(x));
        return ResponseEntity.ok(user);
    }
}
