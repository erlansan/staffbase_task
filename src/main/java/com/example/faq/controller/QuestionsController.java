package com.example.faq.controller;

import com.example.faq.datasource.FaqDataSource;
import com.example.faq.model.Question;
import com.example.faq.service.FaqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("api/questions")
public class QuestionsController extends ExceptionHandlingController{

    @Autowired
    private FaqService faqService;

    @GetMapping
    Collection<Question> getQuestions() {
        return faqService.getQuestions();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Question createQuestion(@RequestBody Question question) {
        return faqService.addQuestion(question);
    }

}
