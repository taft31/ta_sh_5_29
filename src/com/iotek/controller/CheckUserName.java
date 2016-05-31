package com.iotek.controller;

import com.iotek.dao.UserDAOImpl;
import com.iotek.utils.IDType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by taft on 2016/5/30.
 */
@WebServlet(name = "CheckUserName",urlPatterns = "/checkUserName.do")
public class CheckUserName extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String userName = request.getParameter("userName");
        UserDAOImpl userDAO = new UserDAOImpl();
        if (userDAO.isUserNameRepeat(userName)){
            response.getWriter().write("true");
        }else{
            response.getWriter().write("false");
        }
    }
}
