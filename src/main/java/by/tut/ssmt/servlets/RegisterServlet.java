package by.tut.ssmt.servlets;

import by.tut.ssmt.dao.UserData;
import by.tut.ssmt.entities.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("register.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String registerName = req.getParameter("name");
        String registerPass = req.getParameter("pass");
        User user = new User(registerName, registerPass);
        UserData data = UserData.getInstance();
        data.add(user);

        req.setAttribute("userName", registerName);
        doGet(req, resp);

    }

}
