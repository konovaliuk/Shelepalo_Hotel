package dao.interfaces;

import entities.Room;

import java.util.List;

public interface IRoomDao {
    List<Room> findAll();
    Room findById(long id);
    Room save(Room user);
    Room update(long id, Room room);
    void delete(long id);
}
