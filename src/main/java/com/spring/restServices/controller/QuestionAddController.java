package com.spring.restServices.controller;


import com.spring.restServices.Service.UtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class QuestionAddController {

    @Autowired
    UtilService utilService;
    @PostMapping("/addQuestion")
    public ResponseEntity<String> addQuestion(@RequestParam("question") String question, @RequestParam("answer") String answer) {
//        System.out.println("question==="+question);
//        System.out.println("answer==="+answer);
        utilService.saveQuestion(question,answer);
        return ResponseEntity.ok("test");

    }


    @GetMapping("/fetchQuestion/{aid}")
    public String fetchUser(@PathVariable("aid") Long aid){
        return utilService.fetchQuestion(aid);
    }
}
