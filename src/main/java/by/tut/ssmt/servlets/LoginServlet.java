package by.tut.ssmt.servlets;

import by.tut.ssmt.dao.UserData;
import by.tut.ssmt.entities.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String loginName = req.getParameter("name");
        String loginPass = req.getParameter("pass");
        User user = new User(loginName, loginPass);


        UserData data = UserData.getInstance();
        List<String> names = data.listNames();
        List<String> passwords = data.listPasswords();
        List<String> users = data.listUsers();

        req.setAttribute("userName", "wrong");
        for (String str : users) {
            if (user.equals(str)){
                req.setAttribute("userName", "correct");
            }
        }


        doGet(req, resp);
    }
}
