package controller;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.ResultModel;
import dao.SessionObject;
import jdk.nashorn.internal.ir.ObjectNode;
import model.AnswerModel;
import model.QuestionModel;
import model.ReportModel;
import model.UserModel;
import services.AnswerService;
import services.QuestionService;
import services.ReportService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Result;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet("/quiz")
public class QuizController extends HttpServlet {
    ObjectMapper mapper = new ObjectMapper();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        QuestionService questionService = new QuestionService();

        boolean highLevel = false;
        String level = "Easy";
        String jsonSting = req.getParameter("data");
        Map<String,String> myMap = new HashMap<>();
        if(jsonSting != null) {
            myMap = mapper.readValue(jsonSting, HashMap.class);
        }
        if(myMap.get("quesId") != null && myMap.get("ansId") != null) {
            String currentQuesId = myMap.get("quesId");
            String currentAnsId = myMap.get("ansId");
            String quesCSV = "" + req.getSession().getAttribute("quesCSV");
            if("".equals(quesCSV)) {
                req.getSession().setAttribute("quesCSV", currentQuesId);
            } else {
                req.getSession().setAttribute("quesCSV", quesCSV + ", " + currentQuesId);
            }

            //String prevQuesId = "" + req.getSession().getAttribute("prevQuesId");
            String prevAnsId = "" + req.getSession().getAttribute("preAnsId");
            if(currentAnsId.equals(prevAnsId)) {
                String correct  = "" + req.getSession().getAttribute("correctAns");
                int cor = Integer.parseInt(correct);
                cor = cor + 1;
                req.getSession().setAttribute("correctAns", cor);

            } else {
                String wrong= ""+req.getSession().getAttribute("wrongAns");
                int wro = Integer.parseInt(wrong);
                wro = wro +1 ;
                req.getSession().setAttribute("wrongAns", wro);


            }
            QuestionModel prevQues = questionService.getQuestionById(myMap.get("quesId"));
            level = prevQues.getLevel();
            if(Integer.parseInt(""+req.getSession().getAttribute("correctAns")) > Integer.parseInt(""+req.getSession().getAttribute("wrongAns"))) {
                if(prevQues.getLevel().equals("Easy")) {
                    level = "Normal";
                }
                if(prevQues.getLevel().equals("Normal")) {
                    level = "Hard";
                }
                if(prevQues.getLevel().equals("Hard")) {
                    level = "Challenging";
                }
                if(prevQues.getLevel().equals("Challenging")) {
                    level = level;
                }
            } else {
                if(prevQues.getLevel().equals("Challenging")) {
                    level = "Hard";
                }
                if(prevQues.getLevel().equals("Hard")) {
                    level = "Normal";
                }
                if(prevQues.getLevel().equals("Normal")) {
                    level = "Easy";
                }
            }
        }

        //forward request
        String typeId = ""+req.getSession().getAttribute("typeId");
        String quesCSV = "" + req.getSession().getAttribute("quesCSV");
        //req.getSession().setAttribute("correctAns", "0");
        List<QuestionModel> questions = questionService.getQuestionsByTypeId(typeId, quesCSV, level);
        if (questions.size() == 0){
            this.doPost(req, resp);
        }
        if(questions.size() != 0){
            int min=1;
            int max=questions.size();
            int randomnumber = 0;
            if(max > 1) {
                Random random=new Random();
                randomnumber=random.nextInt(max-min)+min;
            }
            QuestionModel questionEntity = questions.get(randomnumber);
            int questId = questionEntity.getId();
            AnswerService answerService = new AnswerService();
            List<AnswerModel> answers = answerService.getAnswersByQuesId(questId);
            String prevAns = "";
            for(AnswerModel entity : answers) {
                    if(entity.getStatus() == 1) {
                        prevAns = entity.getAnswerId();
                    }
                }
            //String prevAnsId = answers.get(0).getAnswerId();
                req.getSession().setAttribute("prevQuesId", questId);
                req.getSession().setAttribute("preAnsId", prevAns);



            if (myMap.get("quesId") == null) {
                req.setAttribute("question", questionEntity);
                req.setAttribute("answers", answers);
                RequestDispatcher view = req.getRequestDispatcher("view/quiz/index.jsp");
                view.forward(req, resp);
            } else {
                ResultModel resultModel = new ResultModel();
                resultModel.setQuestion(questionEntity);
                resultModel.setAnswers(answers);
                resultModel.setFinished(false);
                resultModel.setCorrectAns(""+req.getSession().getAttribute("correctAns"));
                resultModel.setWrongAns(""+req.getSession().getAttribute("wrongAns"));
                resp.setContentType("application/json");
                PrintWriter out = resp.getWriter();
                try {
                    out.write(mapper.writeValueAsString(resultModel));
                    //System.out.print(resultModel.toString());
                } catch (JsonGenerationException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int type_id = Integer.parseInt(""+req.getSession().getAttribute("typeId"));
        int correctAns = Integer.parseInt(""+req.getSession().getAttribute("correctAns"));
        int wrongAns = Integer.parseInt("" + req.getSession().getAttribute("wrongAns"));
        int totalScore = correctAns + wrongAns;
        UserModel user =  (UserModel) req.getSession().getAttribute("user");
        ReportModel reportEntity = new ReportModel(user.getId(),type_id,totalScore,correctAns);
        ReportService reportService = new ReportService();
        reportService.saveReport(reportEntity);
        resp.sendRedirect("report");
    }
}