package com.example.hotel2.comands;

import com.example.hotel2.entities.Users;
import com.example.hotel2.services.UsersService;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CommandSignIn implements ICommand {
    private final static String AUTH_PAGE = "/signin.jsp";
    private final static String MAIN_PAGE = "redirect:/Hotel2_war/";
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
         System.out.println("Executing sign in");
        if (request.getSession().getAttribute("user") != null) {
            return MAIN_PAGE;
        }
        if ("GET".equals(request.getMethod())) {
            return AUTH_PAGE;
        }
        Users user = new UsersService().signIn(request.getParameter("email"),request.getParameter("password"));
        if (user == null) {
            request.setAttribute("message","WRONG CREDENTIALS!");
            return AUTH_PAGE;
        }
        request.getSession().setAttribute("user", user.getEmail());
        return MAIN_PAGE;
    }
}
