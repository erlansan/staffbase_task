package com.example.faq.datasource.mock;

import com.example.faq.datasource.FaqDataSource;
import com.example.faq.model.Question;
import org.junit.jupiter.api.Test;

import java.util.Collection;

public class MockFaqDataSourceTest {

    private FaqDataSource mockFaqDataSource = new MockFaqDataSource();

    @Test
    void shouldProvideACollectionOfQuestions() {
        //when
        Collection<Question> questions = mockFaqDataSource.getQuestions();

        //then
        assert questions.size() >= 3;
    }

    @Test
    void shouldProvideSomeMockData() {
        //when
        Collection<Question> questions = mockFaqDataSource.getQuestions();

        //then
        //all id's are valid
        assert questions.stream().allMatch(question -> question.getId() >= 0);
        //all content is not blank
        assert questions.stream().allMatch(question -> !question.getContent().isBlank());
    }

}
