package com.example.faq.model;

import java.util.Date;

public class Answer {

    private int id;
    private int questionId;
    private String content;
    private Date creationDate;

    public Answer(int id, int questionId, String content) {
        this.id = id;
        this.questionId = questionId;
        this.content = content;
        this.creationDate = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", questionId=" + questionId +
                ", content='" + content + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
