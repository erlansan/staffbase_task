package com.example.faq.controller;

import com.example.faq.model.Answer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;

@RestController
@RequestMapping("api/answers")
public class AnswersController {

    @GetMapping()
    Collection<Answer> getAnswers() {
        return Collections.emptyList();
    }

    @GetMapping("/{questionId}")
    Collection<Answer> getAnswers(@PathVariable String questionId) {
        return Collections.emptyList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Answer createAnswer(@RequestBody Answer answer) {
        return answer;
    }

}
