package com.example.faq.controller;


import com.example.faq.model.Answer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AnswerControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    private String baseUrl = "http://localhost:8080/api/answers";

    @Nested
    @DisplayName("GET /api/answers")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class GetAnswers {

        @Test
        void shouldReturnAllAnswers() throws Exception {
            mockMvc.perform(MockMvcRequestBuilders
                    .get(baseUrl)
                    .accept(MediaType.APPLICATION_JSON))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(MockMvcResultMatchers
                            .jsonPath("$[0].content").value("Answer 1")
            );
        }
    }

    @Nested
    @DisplayName("POST /api/answers")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class PostAnswer {

        @Test
        void shouldAddNewAnswer() throws Exception {
            //given
            Answer answer = new Answer(4, 1, "Answer 4");

            //when
            ResultActions performPost = mockMvc.perform(MockMvcRequestBuilders
                                            .post(baseUrl)
                                            .contentType(MediaType.APPLICATION_JSON)
                                            .content(objectMapper.writeValueAsString(answer)));

            //then
            performPost
                    .andDo(print())
                    .andExpect(status().isCreated())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(content().json(objectMapper.writeValueAsString(answer)));

            String s = objectMapper.writeValueAsString(answer);

            mockMvc.perform(MockMvcRequestBuilders
                    .get(baseUrl + "/" + answer.getId()))
                    .andExpect(content().json(objectMapper.writeValueAsString(answer)));
        }

        @Test
        void shouldReturnBadRequestIfAnswerAlreadyExists() throws Exception {
            //given
            Answer invalidId = new Answer(-1, 1, "Invalid answer -1");
            Answer invalidContent = new Answer(5, 1, "");

            ResultActions performPost = mockMvc.perform(MockMvcRequestBuilders
                                            .post(baseUrl)
                                            .contentType(MediaType.APPLICATION_JSON)
                                            .content(objectMapper.writeValueAsString(invalidId)));

            //then
            performPost.andDo(print())
                    .andExpect(status().isBadRequest());

            //given
            performPost = mockMvc.perform(MockMvcRequestBuilders
                    .post(baseUrl)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(invalidContent)));

            //then
            performPost.andDo(print())
                    .andExpect(status().isBadRequest());
        }
    }

}
