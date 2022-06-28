package dao.implementations;

import dao.interfaces.IOrderDao;
import entities.Order;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements IOrderDao {
    private Connection connection;
    private final String COLUMN_ID = "id";
    private final String COLUMN_USER_ID = "user_id";
    private final String COLUMN_TIME_OF_ARIVE = "time_of_arive";
    private final String COLUMN_COUNT_OF_ROOMS = "count_of_rooms";
    private final String COLUMN_CLASS_OF_APARTMENT = "class_of_apartment";
    private Statement statement;

    public OrderDaoImpl(final Connection connection) throws SQLException {
        this.connection = connection;
        this.statement = connection.createStatement();
    }

    private Order getOrder(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(COLUMN_ID);
        int user_id = resultSet.getInt(COLUMN_USER_ID);
        String time_of_arive = resultSet.getString(COLUMN_TIME_OF_ARIVE);
        int count_of_rooms = resultSet.getInt(COLUMN_COUNT_OF_ROOMS);
        String class_of_apartment = resultSet.getString(COLUMN_CLASS_OF_APARTMENT);

        return new Order(id, user_id, time_of_arive, count_of_rooms, class_of_apartment);
    }

    @Override
    public List<Order> findAll() {
        String query = "SELECT * FROM orders";
        List<Order> orderList = new ArrayList();

        try {
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Order order = getOrder(resultSet);
                orderList.add(order);
            }

            resultSet.close();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }

        return orderList;
    }

    @Override
    public Order findById(long id) {
        String query = "SELECT * FROM orders WHERE orders.id=" + id;

        Order order = new Order();

        try {
            ResultSet resultSet = statement.executeQuery(query);

            resultSet.next();
            order = getOrder(resultSet);

            resultSet.close();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }

        return order;
    }

    @Override
    public Order save(Order order) {
        String query = "INSERT INTO orders (user_id, time_of_arive, count_of_rooms, class_of_apartment) VALUES (";
        query +="'"+ order.getUserId()+"', '" +order.getTimeOfArive()+"',  '"+order.getCountOfRooms()+"', '"+order.getClassOfApartment()+"') " ;
        try {
            statement.execute(query);

        } catch (
                SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Order update(long id, Order order) {
        String query = "UPDATE orders SET user_id = '"+order.getUserId() +"', time_of_arive = '"+order.getTimeOfArive()+"',  count_of_rooms='" + order.getCountOfRooms() + "', class_of_apartment='" + order.getClassOfApartment() + "'WHERE id="+id;

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
        String query = "DELETE FROM orders WHERE id="+id;

        try {
            statement.executeUpdate(query);
        } catch (
                SQLException e) {
            e.printStackTrace();
        }

        return;
    }

}
