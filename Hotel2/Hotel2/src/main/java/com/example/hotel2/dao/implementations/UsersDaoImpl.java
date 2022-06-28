package com.example.hotel2.dao.implementations;

import com.example.hotel2.dao.interfaces.IUsersDao;
import com.example.hotel2.entities.Users;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsersDaoImpl implements IUsersDao {
    private Connection connection;
    private final String COLUMN_ID = "id";
    private final String COLUMN_EMAIL = "email";
    private final String COLUMN_PASSWORD = "password";
    private final String COLUMN_NAME = "name";
    private final String COLUMN_SURNAME = "surname";
    private Statement statement;


    public UsersDaoImpl(final Connection connection) {
        this.connection = connection;
        try {
            this.statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Users getUsers(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(COLUMN_ID);
        String email = resultSet.getString(COLUMN_EMAIL);
        String password = resultSet.getString(COLUMN_PASSWORD);
        String name = resultSet.getString(COLUMN_NAME);
        String surname = resultSet.getString(COLUMN_SURNAME);

        return new Users(id, email, password, name, surname);
    }

    @Override
    public List<Users> findAll() {
        String query = "SELECT * FROM users";
        List<Users> userList = new ArrayList();

        try {
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Users user = getUsers(resultSet);
                userList.add(user);
            }

            resultSet.close();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }

    @Override
    public Users findById(long id) {
        String query = "SELECT * FROM users WHERE users.id=" + id;

        Users user = new Users();

        try {
            ResultSet resultSet = statement.executeQuery(query);

            resultSet.next();
            user = getUsers(resultSet);

            resultSet.close();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public Users findByEmail(String email) {
        String query = "SELECT * FROM users WHERE users.email='" + email+"'";

        Users user = new Users();

        try {
            ResultSet resultSet = statement.executeQuery(query);

            resultSet.next();
            user = getUsers(resultSet);

            resultSet.close();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public Users save(Users user) {
        String query = "INSERT INTO users (email, password, name, surname) VALUES (";
        query +="'"+ user.getEmail()+"', '" +user.getPassword()+"', '"+user.getName()+"', '"+user.getSurname()+"') " ;

        try {
            statement.execute(query);

        } catch (
                SQLException e) {
            e.printStackTrace();
        }


        return user;
    }

    @Override
    public Users update(long id, Users user) {
        String query = "UPDATE users SET email = '"+user.getEmail() +"', password = '"+user.getPassword()+"', name='" + user.getName() + "',  surname='" + user.getSurname() + "' WHERE id="+id;

        try {
            statement.executeUpdate(query);
        } catch (
                SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void delete(long id) {
        String query = "DELETE FROM users WHERE id="+id;

        try {
            statement.executeUpdate(query);
        } catch (
                SQLException e) {
            e.printStackTrace();
        }

        return;
    }
}
