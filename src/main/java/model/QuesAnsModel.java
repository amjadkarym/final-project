package model;

public class QuesAnsModel {
    private int id;
    private int questionId;
    private int answerId;
    private int status;

    public QuesAnsModel(int id, int questionId, int answerId, int status) {
        this.id = id;
        this.questionId = questionId;
        this.answerId = answerId;
        this.status = status;
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

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
