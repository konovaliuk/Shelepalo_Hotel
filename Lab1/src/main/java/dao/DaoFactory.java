package dao;

import dao.implementations.ChargeDaoImpl;
import dao.implementations.OrderDaoImpl;
import dao.implementations.RoomDaoImpl;
import dao.implementations.UsersDaoImpl;
import dao.interfaces.IChargeDao;
import dao.interfaces.IOrderDao;
import dao.interfaces.IRoomDao;
import dao.interfaces.IUsersDao;

import java.sql.Connection;
import java.sql.SQLException;

public class DaoFactory {
    public static IUsersDao createUserDao (Connection connection) throws SQLException {
        return new UsersDaoImpl(connection);
    }

    public static IRoomDao createRoomDao (Connection connection) throws SQLException {
        return new RoomDaoImpl(connection);
    }

    public static IOrderDao createOrderDao (Connection connection) throws SQLException {
        return new OrderDaoImpl(connection);
    }

    public static IChargeDao createChargeDao (Connection connection) throws SQLException {
        return new ChargeDaoImpl(connection);
    }
}
