package dao.interfaces;

import entities.Charge;

import java.util.List;

public interface IChargeDao {
    List<Charge> findAll();
    Charge findById(long id);
    Charge save(Charge user);
    Charge update(long id, Charge charge);
    void delete(long id);
}
