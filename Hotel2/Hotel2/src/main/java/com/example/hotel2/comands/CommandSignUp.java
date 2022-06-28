package com.example.hotel2.comands;


import com.example.hotel2.entities.Users;
import com.example.hotel2.services.UsersService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommandSignUp implements ICommand{
    private final static String REG_PAGE = "/signup.jsp";
    private final static String MAIN_PAGE = "redirect:/Hotel2_war/";
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        // System.out.println("Executing sign up");
        if (request.getSession().getAttribute("user") != null) {
            return MAIN_PAGE;
        }
        if ("GET".equals(request.getMethod())) {
            return REG_PAGE;
        }
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        if (email == null || email.equals("") || password == null || password.equals("")) {
            request.setAttribute("message", "CREDENTIALS MUSTN'T BE EMPTY!");
            return REG_PAGE;
        }
        Users userExists = new UsersService().findUserbyEmail(request.getParameter("email"));
        if (userExists.getEmail() != null) {
            request.setAttribute("message","USERNAME OCCUPIED!");
            return REG_PAGE;
        }

        UsersService.signUp(email, password, name, surname);
        request.getSession().setAttribute("user", email);
        return MAIN_PAGE;
    }
}
