package com.example.faq.controller;

import com.example.faq.model.Answer;
import com.example.faq.service.FaqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("api/answers")
public class AnswersController extends ExceptionHandlingController {

    @Autowired
    private FaqService faqService;

    @GetMapping()
    Collection<Answer> getAnswers() {
        return faqService.getAnswers();
    }

    @GetMapping("/{answerId}")
    Answer getAnswer(@PathVariable int answerId) {
        return faqService.getAnswer(answerId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Answer createAnswer(@RequestBody Answer answer) {
        return faqService.addAnswer(answer);
    }

}
