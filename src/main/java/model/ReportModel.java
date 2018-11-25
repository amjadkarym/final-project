package model;

public class ReportModel {
    private int id;
    private int quizId;
    private int userId;
    private int typeId;
    private int totalScore;
    private int obtainedScore;

    public ReportModel(int userId, int typeId, int totalScore, int obtainedScore) {
        this.quizId = quizId;
        this.userId = userId;
        this.typeId = typeId;
        this.totalScore = totalScore;
        this.obtainedScore = obtainedScore;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public int getObtainedScore() {
        return obtainedScore;
    }

    public void setObtainedScore(int obtainedScore) {
        this.obtainedScore = obtainedScore;
    }
}

