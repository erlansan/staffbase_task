package com.example.faq.controller;

import com.example.faq.datasource.FaqDataSource;
import com.example.faq.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("api/questions")
public class QuestionsController extends ExceptionHandlingController{

    @Autowired
    private FaqDataSource faqDataSource;

    @GetMapping
    Collection<Question> getQuestions() {
        return faqDataSource.getQuestions();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Question createQuestion(@RequestBody Question question) {
        return faqDataSource.createQuestion(question);
    }

}
