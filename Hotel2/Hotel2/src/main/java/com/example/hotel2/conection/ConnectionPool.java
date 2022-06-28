package com.example.hotel2.conection;


import lombok.experimental.UtilityClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

@UtilityClass

public class ConnectionPool {

    private final String URL = "jdbc:postgresql://localhost:5432/HotelBooking";
    private final String USERNAME = "postgres";
    private final String PASSWORD = "1";
        private final List<Connection> connectionPool = new LinkedList<>();
        private final List<Connection> usedConnections = new LinkedList<>();


    public void releaseConnection(Connection connection) {
        connectionPool.add(connection);
        usedConnections.remove(connection);
    }

    private Connection createConnection(String url, String username, String password)
            throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(url, username, password);
    }

    public Connection getConnection() throws SQLException {
        if (connectionPool.isEmpty()) {

            connectionPool.add(createConnection(URL, USERNAME, PASSWORD));
        }
        Connection connection = connectionPool.remove(connectionPool.size() - 1);
        usedConnections.add(connection);
        return connection;
    }

    public void shutdown() throws SQLException {
        usedConnections.forEach(ConnectionPool::releaseConnection);
        for (Connection connection : connectionPool) {
            connection.close();
        }
        connectionPool.clear();
    }
}


