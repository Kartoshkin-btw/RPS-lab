/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import service.RouteService;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Route;

/**
 *
 * @author utkin
 */
public class RouteServiceImpl implements RouteService{

    @PersistenceContext(unitName = "Priject")
    private EntityManager entityManager;

    @Override
    public List<Route> getAll() {
        List<Route> result = entityManager.createQuery("SELECT u FROM Route u").getResultList();
        return result;
    }

    @Override
    public void create(Route route) {
        entityManager.persist(route);
    }

    @Override
    public void edit(Route route) {
        entityManager.merge(route);
    }

    @Override
    public void remove(Route route) {
        entityManager.merge(route);
    }

    @Override
    public Route getById(int id) {
        return entityManager.find(Route.class, id);
    }
}
