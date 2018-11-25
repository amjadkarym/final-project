package dao;

import model.AnswerModel;
import model.QuestionModel;

import java.util.List;

public class ResultModel {
    private QuestionModel question;
    private List<AnswerModel> answers;
    private boolean finished;
    private String correctAns;
    private String wrongAns;

    public boolean isFinished() {
        return finished;
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

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public QuestionModel getQuestion() {
        return question;
    }

    public void setQuestion(QuestionModel question) {
        this.question = question;
    }

    public List<AnswerModel> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerModel> answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "ResultModel{" +
                "question=" + question +
                ", answers=" + answers +
                '}';
    }
}
