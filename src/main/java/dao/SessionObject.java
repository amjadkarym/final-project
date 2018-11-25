package dao;

public class SessionObject {

    private String typeId;
    private String correctAns;
    private String wrongAns;
    private String quesCSV;
    private String prevQuesId;
    private String preAnsId;

    public SessionObject(String typeId, String correctAns, String wrongAns, String quesCSV, String prevQuesId, String preAnsId) {
        this.typeId = typeId;
        this.correctAns = correctAns;
        this.wrongAns = wrongAns;
        this.quesCSV = quesCSV;
        this.prevQuesId = prevQuesId;
        this.preAnsId = preAnsId;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getCorrectAns() {
        return correctAns;
    }

    public void setCorrectAns(String correctAns) {
        this.correctAns = correctAns;
    }

    public String getWrongAns() {
        return wrongAns;
    }

    public void setWrongAns(String wrongAns) {
        this.wrongAns = wrongAns;
    }

    public String getQuesCSV() {
        return quesCSV;
    }

    public void setQuesCSV(String quesCSV) {
        this.quesCSV = quesCSV;
    }

    public String getPrevQuesId() {
        return prevQuesId;
    }

    public void setPrevQuesId(String prevQuesId) {
        this.prevQuesId = prevQuesId;
    }

    public String getPreAnsId() {
        return preAnsId;
    }

    public void setPreAnsId(String preAnsId) {
        this.preAnsId = preAnsId;
    }
}
