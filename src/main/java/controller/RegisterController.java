package controller;

import model.UserModel;
import services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/register")
public class RegisterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/view/users/forms.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("reg_username");
        String password = req.getParameter("reg_password");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        UserService userService = new UserService();
        UserModel user = new UserModel();
        user.setUsername(username);
        user.setPassword(password);
        user.setFirstname(firstName);
        user.setLastname(lastName);
        userService.createUser(user);
        resp.sendRedirect("login");
    }
}