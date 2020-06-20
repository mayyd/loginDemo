package com.top.mayyd.servlet;

import com.top.mayyd.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loginSuccess")
public class loginSuccess extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html,charst=utf-8");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-type", "text/html;charset=UTF-8");


        try {
            User user = (User)request.getAttribute("user");
            if (user == null) {
                throw new Exception("loggin failed");
            }

            PrintWriter writer = response.getWriter();
            writer.println("欢迎您，"+ user.getUsername() +" ！");
        } catch (Exception e) {
            request.getRequestDispatcher("/loginFailed").forward(request, response);
        }
    }
}
