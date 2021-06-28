package com.example.faq.datasource.mock;

import com.example.faq.FaqApplication;
import com.example.faq.datasource.FaqDataSource;
import com.example.faq.model.Answer;
import com.example.faq.model.Question;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("mock")
public class MockFaqDataSource implements FaqDataSource {

    List<Question> questions = new ArrayList<>(
            Arrays.asList(
                    new Question(1,"Question 1"),
                    new Question(2,"Question 2"),
                    new Question(3,"Question 3")));

    List<Answer> answers = new ArrayList<>(
            Arrays.asList(
                    new Answer(1, 1, "Answer 1"),
                    new Answer(2, 2, "Answer 2"),
                    new Answer(3, 3, "Answer 3")
            )
    );


    @Override
    public Collection<Question> getQuestions() {
        return questions;
    }

    @Override
    public Question createQuestion(Question question) {
        if(questions.stream().anyMatch(question1 -> question1.getId() == question.getId())) {
            System.out.println("Element with this id " + question.getId() + " already exists");
            return null;
        }
        questions.add(question);
        return question;
    }

    @Override
    public Collection<Answer> getAnswers() {
        return answers;
    }

    @Override
    public Answer getAnswer(int questionId) {
        Optional<Answer> foundAnswer = answers.stream().filter(answer -> answer.getId() == questionId).findFirst();
        return foundAnswer.get();
    }

    @Override
    public Answer createAnswer(Answer answer) {
        if(answers.stream().anyMatch(answer1 -> answer1.getId() == answer.getId())) {
            System.out.println("Element with this id " + answer.getId() + " already exists");
            return null;
        }
        answers.add(answer);
        return answer;
    }
}
