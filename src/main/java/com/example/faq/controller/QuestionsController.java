package com.example.faq.controller;

import com.example.faq.model.Answer;
import com.example.faq.model.Question;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;

@RestController("api/questions")
public class QuestionsController {

    @GetMapping
    Collection<Question> getQuestions() {
        //TODO
        return Collections.emptyList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Question createQuestion(@RequestBody Question question) {
        //TODO
        return question;
    }

}
