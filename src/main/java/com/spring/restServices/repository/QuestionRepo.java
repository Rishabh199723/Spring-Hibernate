package com.spring.restServices.repository;

import com.spring.restServices.entity.Answer;
import com.spring.restServices.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public class QuestionRepo  {

    @Autowired
    HibernateTemplate template;

    @Transactional
    public String saveQuestion(String question, String answer) {
        Question q = new Question();
        q.setQuestion(question);
        Answer ans = new Answer();
        ans.setAnswer(answer);
        q.setAnswer(ans);
        template.save(q);
        return "Saved";
    }

    public String fetchQuestion(Long aid) {
        Optional<Answer> q = Optional.ofNullable(template.get(Answer.class, aid));
        return (q.isPresent()) ? q.get().getQuestion().getQuestion() : "No Question available";

    }
}
