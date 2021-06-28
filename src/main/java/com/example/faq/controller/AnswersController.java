package com.example.faq.controller;

import com.example.faq.datasource.FaqDataSource;
import com.example.faq.model.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("api/answers")
public class AnswersController {

    @Autowired
    private FaqDataSource faqDataSource;

    @GetMapping()
    Collection<Answer> getAnswers() {
        return faqDataSource.getAnswers();
    }

    @GetMapping("/{questionId}")
    Answer getAnswer(@PathVariable int questionId) {
        return faqDataSource.getAnswer(questionId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Answer createAnswer(@RequestBody Answer answer) {
        return faqDataSource.createAnswer(answer);
    }

}
