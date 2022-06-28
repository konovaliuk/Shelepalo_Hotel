package dao.interfaces;

import entities.Users;

import java.util.List;

public interface IUsersDao {
    List<Users> findAll();
    Users findById(long id);
    Users save(Users user);
    Users update(long id, Users user);
    void delete(long id);
}
