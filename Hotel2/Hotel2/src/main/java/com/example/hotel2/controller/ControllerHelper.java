package com.example.hotel2.controller;

import com.example.hotel2.comands.CommandSignIn;
import com.example.hotel2.comands.CommandSignOut;
import com.example.hotel2.comands.CommandSignUp;
import com.example.hotel2.comands.ICommand;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public class ControllerHelper {
    private static final String COMMAND = "command";
    private static ControllerHelper instance = null;
    HashMap<String, ICommand> commands = new HashMap<>();

    private ControllerHelper() {
        commands.put("/Hotel2_war/signin", new CommandSignIn());
        commands.put("/Hotel2_war/register", new CommandSignUp());
        commands.put("/Hotel2_war/signout", new CommandSignOut());
    }

    public ICommand getCommand(HttpServletRequest request) {
        // System.out.println(request.getRequestURI());
        return commands.get(request.getRequestURI());
    }

    public static ControllerHelper getInstance() {
        if (instance == null) {instance = new ControllerHelper();}
        return instance;
    }


}
