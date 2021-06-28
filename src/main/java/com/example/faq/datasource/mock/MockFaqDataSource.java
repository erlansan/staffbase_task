package com.example.faq.datasource.mock;

import com.example.faq.FaqApplication;
import com.example.faq.datasource.FaqDataSource;
import com.example.faq.model.Answer;
import com.example.faq.model.Question;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("mock")
public class MockFaqDataSource implements FaqDataSource {

    private static int questionIdNum = 0;
    private static int answerIdNum = 0;

    List<Question> questions = new ArrayList<>(
            Arrays.asList(
                    new Question(questionIdNum++,"Question 1"),
                    new Question(questionIdNum++,"Question 2"),
                    new Question(questionIdNum++,"Question 3")));

    List<Answer> answers = new ArrayList<>(
            Arrays.asList(
                    new Answer(answerIdNum++, 1, "Answer 1"),
                    new Answer(answerIdNum++, 2, "Answer 2"),
                    new Answer(answerIdNum++, 3, "Answer 3")
            )
    );


    @Override
    public Collection<Question> getQuestions() {
        return questions;
    }

    @Override
    public Question createQuestion(Question question) {
        if(question.getId() < 0) {
            throw new IllegalArgumentException(question.getId() + " is invalid id value.");
        }
        if(question.getContent().isBlank()) {
            throw new IllegalArgumentException("Question content is empty.");
        }
        if(questions.stream().anyMatch(question1 -> question1.getId() == question.getId())) {
            throw new IllegalArgumentException("Question with this id: " + question.getId() + " already exists");
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
        if(foundAnswer.isEmpty()) {
            throw new NoSuchElementException("Answer with this question id: " + questionId + " doesn't exists");
        }
        return foundAnswer.get();
    }

    @Override
    public Answer createAnswer(Answer answer) {
        if(answer.getId() < 0) {
            throw new IllegalArgumentException(answer.getId() + " is invalid id value.");
        }
        if(answer.getContent().isBlank()) {
            throw new IllegalArgumentException("Answer content is empty.");
        }
        if(answers.stream().anyMatch(answer1 -> answer1.getId() == answer.getId())) {
            throw new IllegalArgumentException("Answer with this id: " + answer.getId() + " already exists");
        }
        answers.add(answer);
        return answer;
    }
}
