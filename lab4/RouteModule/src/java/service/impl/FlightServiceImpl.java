/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import domain.Flight;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJBException;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import service.BookService;

@Stateless
public class FlightServiceImpl implements FlightService{
    
    @PersistenceContext(unitName = "RoutesModulePU")
    private EntityManager entityManager;

    @Resource
    private SessionContext sessionContext;

    @Override
    public List<Flight> findAll() {
        List<Flight> result = entityManager.createQuery("SELECT u from Flight u").getResultList();
        return result;
    }

    @Override
    public Flight find(int id) {
        return entityManager.find(Flight.class, id);
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
    public void throwExceprion(Flight flight) throws EJBException{
        entityManager.persist(flight);
        throw new EJBException();
    }

    @Override
    public void rollBack(Flight flight) {
        entityManager.persist(flight);
        sessionContext.setRollbackOnly();
    }

    @Override
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public void noTransact(Flight flight) {
        entityManager.persist(flight);
    }

    @Override
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void transact(Flight flight) {
        entityManager.persist(flight);
    }
        
}
