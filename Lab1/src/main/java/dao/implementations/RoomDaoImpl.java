package dao.implementations;

import dao.interfaces.IRoomDao;
import entities.Room;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RoomDaoImpl implements IRoomDao {
    private Connection connection;
    private final String COLUMN_ID = "id";
    private final String COLUMN_TYPE = "type";
    private final String COLUMN_BEDS = "beds";
    private final String COLUMN_STATUS = "status";
    private Statement statement;

    public RoomDaoImpl(final Connection connection) throws SQLException {
        this.connection = connection;
        this.statement = connection.createStatement();
    }

    private Room getRoom(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong(COLUMN_ID);
        String type = resultSet.getString(COLUMN_TYPE);
        String beds = resultSet.getString(COLUMN_BEDS);
        String status = resultSet.getString(COLUMN_STATUS);

        return new Room(id, type, beds, status );
    }

    @Override
    public List<Room> findAll() {
        String query = "SELECT * FROM room";
        List<Room> roomList = new ArrayList();

        try {
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Room room = getRoom(resultSet);
                roomList.add(room);
            }

            resultSet.close();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }

        return roomList;
    }

    @Override
    public Room findById(long id) {
        String query = "SELECT * FROM room WHERE room.id=" + id;

        Room room = new Room();

        try {
            ResultSet resultSet = statement.executeQuery(query);

            resultSet.next();
            room = getRoom(resultSet);

            resultSet.close();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }

        return room;
    }


    @Override
    public Room save(Room room) {
        String query = "INSERT INTO room (type, beds, status) VALUES (";
        query +="'"+ room.getType()+"', '" +room.getBeds()+"',  '"+room.getStatus()+"') " ;
        try {
            statement.execute(query);

        } catch (
                SQLException e) {
            e.printStackTrace();
        }

        return room;
    }

    @Override
    public Room update(long id, Room room) {
        String query = "UPDATE room SET type = '"+room.getType() +"', beds = '"+room.getBeds()+"',  status='" + room.getStatus() + "' WHERE id="+id;

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
        String query = "DELETE FROM room WHERE id="+id;

        try {
            statement.executeUpdate(query);
        } catch (
                SQLException e) {
            e.printStackTrace();
        }

        return;
    }

}
