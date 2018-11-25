package services;

import dao.AnswerDao;
import model.AnswerModel;

import java.util.List;

public class AnswerService {

    static AnswerDao answerDao = new AnswerDao();

    public AnswerModel getAnswerById(int id) {
        AnswerModel answer = answerDao.getAnswerById(id);
        return answer;
    }

    public List<AnswerModel> getAnswersByQuesId(int quesId) {
        List<AnswerModel> answer = answerDao.getAnswersByQuesId(quesId);
        return answer;
    }

}
