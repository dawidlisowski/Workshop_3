package pl.coderslab.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pl.coderslab.entity.User;
import pl.coderslab.entity.UserDao;

import java.io.IOException;

@WebServlet("/user/edit")
public class UserEdit extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("id");
        User user = UserDao.read(Integer.parseInt(userId));
        request.setAttribute("user", user);
        getServletContext().getRequestDispatcher("/users/edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("id");
        User user = UserDao.read(Integer.parseInt(userId));
        String name = request.getParameter("userName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        user.setUserName(name);
        user.setEmail(email);
        user.setPassword(password);
        UserDao.update(user);
        response.sendRedirect("/user/list");
    }
}
