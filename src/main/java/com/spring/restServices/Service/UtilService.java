package com.spring.restServices.Service;

import com.spring.restServices.repository.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UtilService {

    @Autowired
    QuestionRepo questionRepo;

    public String saveQuestion(String question, String answer) {
        return questionRepo.saveQuestion(question,answer);
    }

    public String fetchQuestion(Long aid) {
        return questionRepo.fetchQuestion(aid);
    }
}
