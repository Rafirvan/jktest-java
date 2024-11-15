package com.rafirvan.jktestjava.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userID = request.getParameter("userID");
        String password = request.getParameter("password");

        if ("123456".equals(userID) && "password".equals(password)) {
            request.setAttribute("userID", userID);
            request.getRequestDispatcher("/welcome").forward(request, response);
        } else {
            response.getWriter().println("<h1>Invalid credentials. Try again.</h1>");
        }
    }
}
