package dao.implementations;

import dao.interfaces.IChargeDao;
import entities.Charge;
import entities.Order;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ChargeDaoImpl implements IChargeDao {
    private Connection connection;
    private final String COLUMN_ID = "id";
    private final String COLUMN_PRICE = "price";
    private final String COLUMN_USER_ID = "user_id";
    private final String COLUMN_ROOM_ID = "room_id";
    private Statement statement;

    public ChargeDaoImpl(final Connection connection) throws SQLException {
        this.connection = connection;
        this.statement = connection.createStatement();
    }

    private Charge getCharge(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(COLUMN_ID);
        int price = resultSet.getInt(COLUMN_PRICE);
        int user_id = resultSet.getInt(COLUMN_USER_ID);
        int room_id = resultSet.getInt(COLUMN_ROOM_ID);

        return new Charge(id, price, user_id, room_id);
    }

    @Override
    public List<Charge> findAll() {
        String query = "SELECT * FROM charge";
        List<Charge> roomList = new ArrayList();

        try {
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Charge charge = getCharge(resultSet);
                roomList.add(charge);
            }

            resultSet.close();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }

        return roomList;
    }

    @Override
    public Charge findById(long id) {
        String query = "SELECT * FROM charge WHERE charge.id=" + id;

        Charge charge = new Charge();

        try {
            ResultSet resultSet = statement.executeQuery(query);

            resultSet.next();
            charge = getCharge(resultSet);

            resultSet.close();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }

        return charge;
    }

    @Override
    public Charge save(Charge charge) {
        String query = "INSERT INTO charge (price, user_id, room_id) VALUES (";
        query +="'"+ charge.getPrice()+"', '" +charge.getUserId()+"',  '"+charge.getRoomId()+"') " ;
        try {
            statement.execute(query);

        } catch (
                SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Charge update(long id, Charge charge) {
        String query = "UPDATE charge SET price = '"+charge.getPrice() +"', user_id = '"+charge.getUserId()+"',  room_id='" + charge.getRoomId() + "' WHERE id="+id;

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
        String query = "DELETE FROM charge WHERE id="+id;

        try {
            statement.executeUpdate(query);
        } catch (
                SQLException e) {
            e.printStackTrace();
        }

        return;
    }
}
