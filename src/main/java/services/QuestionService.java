package services;

import dao.QuestionDao;
import model.QuestionModel;

import java.util.List;

public class QuestionService {

    static QuestionDao questionDao = new QuestionDao();

    public QuestionModel getQuestionById(String id) {
        QuestionModel question = questionDao.getQuestionById(id);
        return question;
    }

    public List<QuestionModel> getQuestionsByTypeId(String typeId, String quesCSV, String level) {
        List<QuestionModel> questions = questionDao.getQuestionsByTypeId(typeId, quesCSV, level);
        return questions;
    }

}
