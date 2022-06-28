package com.example.hotel2.dao.interfaces;

import com.example.hotel2.entities.Users;

import java.util.List;

public interface IUsersDao {
    List<Users> findAll();
    Users findById(long id);
    Users save(Users user);
    Users update(long id, Users user);
    Users findByEmail(String email);
    void delete(long id);
}