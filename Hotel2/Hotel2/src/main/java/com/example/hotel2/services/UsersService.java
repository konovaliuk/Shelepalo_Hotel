package com.example.hotel2.services;

import com.example.hotel2.conection.ConnectionPool;
import com.example.hotel2.dao.implementations.UsersDaoImpl;
import com.example.hotel2.entities.Users;

import java.sql.Connection;
import java.sql.SQLException;

public class UsersService {
    public static void signUp(String email, String password, String name, String surname) {
        try {
            Connection connection = ConnectionPool.getConnection();
            UsersDaoImpl userDAO = new  UsersDaoImpl(connection);
            Users user = new Users(email, password, name, surname);
            int userId = userDAO.save(user).getId();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Users signIn(String email, String password) {
        try {
            Connection connection = ConnectionPool.getConnection();
            UsersDaoImpl userDAO = new UsersDaoImpl(connection);
            Users user = userDAO.findByEmail(email);

            if (user == null) {
                return null;
            }

            if (password.equals(user.getPassword())) {
                return user;
            }
            else {
                return null;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public Users findUserbyEmail(String email){
        try {
            Connection connection = ConnectionPool.getConnection();
            UsersDaoImpl userDAO = new UsersDaoImpl(connection);
            Users user = userDAO.findByEmail(email);

            if (user == null) return null;
            else {
                return user;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
