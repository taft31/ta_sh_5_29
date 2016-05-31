package com.iotek.controller;

import com.iotek.dao.UserDAOImpl;
import com.iotek.model.UsersEntity;
import com.iotek.utils.IDType;
import com.iotek.utils.RoundID;
import com.sun.corba.se.spi.ior.iiop.RequestPartitioningComponent;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by taft on 2016/5/29.
 */
@WebServlet(name = "Register",urlPatterns = "/register.do")
public class Register extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String userName = request.getParameter("userName");
        String userPass = request.getParameter("userPass");

        UsersEntity usersEntity = new UsersEntity();
        usersEntity.setId(RoundID.getID(IDType.USER));
        usersEntity.setName(userName);
        usersEntity.setPass(userPass);
        UserDAOImpl userDAO = new UserDAOImpl();
        String resultPage = "";
        if (userDAO.createUser(usersEntity)){
            request.setAttribute("userName",userName);
            resultPage = "pages/registerSuccess.jsp";
        }else{
            request.setAttribute("error","∑˛ŒÒ∆˜“Ï≥£◊¢≤· ß∞‹£¨«Î÷ÿ ‘!");
            resultPage = "pages/login.jsp";
        }
        request.getRequestDispatcher(resultPage).forward(request,response);
    }
}
