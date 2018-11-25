package controller;

import services.QuestionService;
import services.TypeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/type")
public class TypeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TypeService typeService = new TypeService();
        req.setAttribute("types", typeService.getTypes());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/view/type/home.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String typeId = req.getParameter("type");
        //HttpSession session = req.getSession();
        req.getSession().setAttribute("typeId", typeId);
        req.getSession().setAttribute("correctAns", "0");
        req.getSession().setAttribute("wrongAns", "0");
        req.getSession().setAttribute("quesCSV", "");
        req.getSession().setAttribute("prevQuesId", "");
        req.getSession().setAttribute("preAnsId", "");
        String quizURI = req.getContextPath()+"/quiz";
        resp.sendRedirect(quizURI);

    }


}