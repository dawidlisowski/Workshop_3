package pl.coderslab.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pl.coderslab.entity.User;
import pl.coderslab.entity.UserDao;

import java.io.IOException;

@WebServlet("/user/show")
public class UserShow extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("id");
        User user = UserDao.read(Integer.parseInt(userId));
        request.setAttribute("user", user);
        getServletContext().getRequestDispatcher("/users/show.jsp").forward(request, response);
    }
}
