package com.zelcek.umur;

public class Question {
    private int imageId;
    private String question;
    private String correctAnswer;
    private String[] wrongAnswers;
    private String description;

    public Question(int imageId, String question, String correctAnswer, String[] wrongAnswers, String description) {
        this.imageId = imageId;
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.wrongAnswers = wrongAnswers;
        this.description = description;
    }

    public int getImageId() {
        return imageId;
    }

    public String getQuestion() {
        return question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String[] getWrongAnswers() {
        return wrongAnswers;
    }

    public String getDescription() {
        return description;
    }
}
