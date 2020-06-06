/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import domain.Library;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJBException;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import service.LibraryService;

@Stateless
public class EmployeeServiceImpl implements EmployeeService{
    
    @PersistenceContext(unitName = "EmployeesModulePU")
    private EntityManager entityManager;
    
    @Resource
    private SessionContext sessionContext;

    @Override
    public List<Employee> findAll() {
        List<Employee> result = entityManager.createQuery("SELECT u FROM Employee u").getResultList();
        return result;
    }
    @Override
    public Employee find(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public void create(Employee employee) {
        entityManager.persist(employee);
    }

    @Override
    public void edit(Employee employee) {
        entityManager.merge(employee);
    }

    @Override
    public void remove(Employee employee) {
        entityManager.remove(entityManager.merge(employee));
    }

    @Override
    public void throwException(Employee employee) throws EJBException{
        entityManager.persist(employee);
        throw new EJBException();
    }

    @Override
    public void rollBack(Employee employee) {
        entityManager.persist(employee);
        sessionContext.setRollbackOnly();
    }

    @Override
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public void noTransact(Employee employee) {
        entityManager.persist(employee);
    }

    @Override
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void newTransact(Employee employee) {
        entityManager.persist(employee);
    }
}
