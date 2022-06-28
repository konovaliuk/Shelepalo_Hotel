package dao.interfaces;


import entities.Order;

import java.util.List;

public interface IOrderDao {
    List<Order> findAll();
    Order findById(long id);
    Order save(Order user);
    Order update(long id, Order order);
    void delete(long id);
}
