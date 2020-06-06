/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import domain.Route;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJBException;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import service.AuthorService;

@Stateless
public class RouteServiceImpl implements RouteService{

    @PersistenceContext(unitName = "RoutesModulePU")
    private EntityManager entityManager;
     
    @Resource
    private SessionContext sessionContext;

    @Override
    public List<Route> findAll() {
        List<Route> result = entityManager.createQuery("SELECT u from Route u").getResultList();
        return result;
    }

    @Override
    public Route find(int id) {
        return entityManager.find(Route.class, id);
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
        entityManager.remove(route);
    }

    @Override
    public void throwExceprion(Route route) throws EJBException{
        entityManager.persist(route);
        throw new EJBException();
    }

    @Override
    public void rollBack(Route route) {
        entityManager.persist(route);
        sessionContext.setRollbackOnly();
    }

    @Override
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public void noTrastact(Route route) {
        entityManager.persist(route);
    }

    @Override
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void transact(Route route) {
        entityManager.persist(route);
    }
}
