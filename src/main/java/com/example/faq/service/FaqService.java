package com.example.faq.service;

import com.example.faq.datasource.FaqDataSource;
import com.example.faq.model.Answer;
import com.example.faq.model.Question;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
public class FaqService {

    @Qualifier("mock")
    private FaqDataSource faqDataSource;

    public FaqService(FaqDataSource faqDataSource) {
        this.faqDataSource = faqDataSource;
    }

    public Collection<Question> getQuestions() {
        return faqDataSource.getQuestions();
    }

    public Question addQuestion(Question question) {
        return faqDataSource.createQuestion(question);
    }

    public Collection<Answer> getAnswers() {
        return faqDataSource.getAnswers();
    }

    public Answer addAnswer(Answer answer) {
        return faqDataSource.createAnswer(answer);
    }

    public Answer getAnswer(int answerId) {
        return faqDataSource.getAnswer(answerId);
    }
}
