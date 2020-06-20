package com.top.mayyd.servlet;

import com.top.mayyd.dao.UserDao;
import com.top.mayyd.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/login")
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("login..");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html,charst=utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setHeader("Content-type", "text/html;charset=UTF-8");


        //获取请求参数，并封装层 JavaBean，通过 BeanUtils 快速封装
        try {
            User loginUser = new User();
            Map<String, String[]> map = req.getParameterMap();
            BeanUtils.populate(loginUser, map);

            User user = new UserDao().login(loginUser);
            if (user != null) {
                //登录成功
                System.out.println("登录成功");
                req.setAttribute("user", user);
                req.getRequestDispatcher("/loginSuccess").forward(req,resp);
            } else {
                //登录失败
                System.out.println("登录失败，用户名或者密码错误");
                req.getRequestDispatcher("/loginFailed").forward(req, resp);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
