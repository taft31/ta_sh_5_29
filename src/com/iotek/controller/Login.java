package com.iotek.controller;

import com.iotek.dao.UserDAOImpl;
import com.iotek.dto.UserDTO;
import com.iotek.model.UsersEntity;
import com.iotek.utils.IDType;
import com.iotek.utils.MD5;
import com.iotek.utils.RoundID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by taft on 2016/5/29.
 */
@WebServlet(name = "Login",urlPatterns = "/login.do")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String userPass = request.getParameter("userPass");

        UsersEntity usersEntity = new UsersEntity();
        usersEntity.setId(RoundID.getID(IDType.USER));
        usersEntity.setName(userName);
        usersEntity.setPass(MD5.GetMD5Code(userPass));

        UserDAOImpl userDAO = new UserDAOImpl();

        UsersEntity usersEntityLoad = userDAO.checkLogin(usersEntity);

        HttpSession session = request.getSession();
        if (null!=usersEntityLoad){
            System.out.println(usersEntityLoad);
            List<UserDTO> userDTOs = userDAO.listUser(usersEntityLoad);
            session.setAttribute("loginUser",userDTOs);
            request.getRequestDispatcher("pages/loginSuccess.jsp").forward(request,response);
        }else{
            System.out.println("用户名或密码错误");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
        this.doPost(request,response);
    }
}
