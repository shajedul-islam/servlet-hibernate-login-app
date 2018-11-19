package com.uiu.cdip.loginapp.controller;

import com.uiu.cdip.loginapp.dao.UserDAO;
import com.uiu.cdip.loginapp.dao.UserDAOImpl;
import com.uiu.cdip.loginapp.model.User;
import com.uiu.cdip.loginapp.service.UserService;
import com.uiu.cdip.loginapp.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("registration.jsp");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String msg = "Password and Conform Passwords must be same";
        String page = "registration.jsp";
        if(request.getParameter("password1").equals(request.getParameter("password2"))){
            User user = new User();
            user.setUsername(request.getParameter("username"));
            user.setPassword(request.getParameter("password1"));
            user.setFirstName(request.getParameter("firstName"));
            user.setLastName(request.getParameter("lastName"));
            user.setEmail(request.getParameter("email"));
            user.setMobileNumber(request.getParameter("mobileNumber"));

            System.out.println(user.toString());
            //UserDAO userDAO = new UserDAOImpl();
            UserService userService = new UserServiceImpl();
            msg = userService.registration(user);
            page = "login.jsp";
        }
        request.setAttribute("msg2", msg);
        request.getRequestDispatcher(page).include(request, response);
    }

}
