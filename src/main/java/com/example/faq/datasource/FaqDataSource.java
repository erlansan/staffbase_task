package com.example.faq.datasource;

import com.example.faq.model.Answer;
import com.example.faq.model.Question;

import java.util.Collection;

public interface FaqDataSource {

    Collection<Question> getQuestions();

    Question createQuestion(Question question);

    Collection<Answer> getAnswers();

    Answer getAnswer(int questionId);

    Answer createAnswer(Answer answer);

}
