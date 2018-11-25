package model;

public class QuestionModel {
    private int id;
    private String title;
    private int typeId;
    private String level;

    public QuestionModel() {

    }
    public QuestionModel(int id, String title, int typeId, String level) {
        this.id = id;
        this.title = title;
        this.typeId = typeId;
        this.level = level;
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

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
