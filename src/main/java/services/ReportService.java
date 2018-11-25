package services;

import dao.AnswerDao;
import dao.ReportDao;
import model.AnswerModel;
import model.ReportModel;

import java.util.List;

public class ReportService {

    static ReportDao reportDao = new ReportDao();

    public void saveReport(ReportModel reportModel) {
        reportDao.saveReport(reportModel);
    }


}
