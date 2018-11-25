package model;

public class AnswerModel {
    private int id;
    private String title;
    private String answerId;
    private int status;

    public AnswerModel() {

    }
    public AnswerModel(int id, String title, String answerId, int status) {
        this.id = id;
        this.title = title;
        this.answerId = answerId;
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getAnswerId() {
        return answerId;
    }

    public void setAnswerId(String answerId) {
        this.answerId = answerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
