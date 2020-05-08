/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import service.FlightService;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Flight;

/**
 *
 * @author utkin
 */
public class FlightServiceImpl implements FlightService{

    @PersistenceContext(unitName = "Priject")
    private EntityManager entityManager;
    @Override
    public List<Flight> getAll() {
        List<Flight> result = entityManager.createQuery("SELECT u FROm Flight u").getResultList();
        return result;
    }

    @Override
    public void create(Flight flight) {
        entityManager.persist(flight);
    }

    @Override
    public void edit(Flight flight) {
        entityManager.merge(flight);
    }

    @Override
    public void remove(Flight flight) {
        entityManager.remove(entityManager.merge(flight));
    }

    @Override
    public Flight getById(int id) {
        return entityManager.find(Flight.class, id);
    }
}
