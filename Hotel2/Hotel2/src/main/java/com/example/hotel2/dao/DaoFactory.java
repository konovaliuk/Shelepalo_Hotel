package com.example.hotel2.dao;

import com.example.hotel2.dao.implementations.UsersDaoImpl;
import com.example.hotel2.dao.interfaces.IUsersDao;

import java.sql.Connection;
import java.sql.SQLException;

public class DaoFactory {
    public static IUsersDao createUserDao (Connection connection) throws SQLException {
        return new UsersDaoImpl(connection);
    }
}
