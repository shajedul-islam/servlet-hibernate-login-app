package com.uiu.cdip.loginapp.controller;

import com.uiu.cdip.loginapp.service.UserService;
import com.uiu.cdip.loginapp.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;


    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("login.jsp");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println(username + " :: " + password);
        String page = "login.jsp";
        if(username.trim().length() >= 0 && username != null &&
                password.trim().length() >= 0 && password != null) {
            UserService loginService = new UserServiceImpl();
            boolean flag = loginService.login(username, password);
            if(flag) {
                System.out.println("Login success!!!");
                request.setAttribute("username", username);
                request.setAttribute("msg", "Login Success.....");
                page = "home.jsp";
            } else {
                request.setAttribute("msg", "Wrong Username or Password, Try again!!!");
            }
        } else {
            request.setAttribute("msg", "Please enter username and password...");
        }
        request.getRequestDispatcher(page).include(request, response);
    }
}
