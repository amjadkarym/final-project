package controller;

import model.UserModel;
import services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet({"/login", ""})
public class UserController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = "";
        if (req.getCookies() != null)
        for (Cookie cookie : req.getCookies()) {
            if (cookie.getName().equals("Username")) {
                userName = cookie.getValue();
                req.setAttribute("username", userName);
                System.out.println(userName);
            }
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/view/users/forms.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String remember = req.getParameter("remember");
        Cookie cookie = new Cookie("Username", username);
        if(remember != null) {
            cookie.setMaxAge(3600); //in seconds
            resp.addCookie(cookie);
        } else {
            cookie.setMaxAge(-1);
            resp.addCookie(cookie);
        }
        UserService userService = new UserService();
        UserModel user = new UserModel();
        List<UserModel> users = userService.getUsers();
        if(users != null) {
            for (UserModel userEntity : users) {
                if (userEntity.getUsername().equals(username)) {
                    user = userEntity;
                }
            }
            if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
                HttpSession session = req.getSession();
                session.setAttribute("user", user);
                resp.sendRedirect("/type");
            } else {
                resp.sendRedirect("login");
            }
        } else {
            resp.sendRedirect("login");
        }

    }



}