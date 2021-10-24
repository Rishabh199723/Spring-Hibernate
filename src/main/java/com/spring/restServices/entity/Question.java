package com.spring.restServices.entity;

import javax.persistence.*;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long qid;
    private String question;
    @OneToOne(cascade = CascadeType.ALL)
    private Answer answerRef;

    public Long getQid() {
        return qid;
    }

    public void setQid(Long qid) {
        this.qid = qid;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Answer getAnswer() {
        return answerRef;
    }

    public void setAnswer(Answer answer) {
        this.answerRef = answer;
    }

    public Question(Long qid, String question, Answer answer) {
        this.qid = qid;
        this.question = question;
        this.answerRef = answer;
    }
    public Question(){}
}
