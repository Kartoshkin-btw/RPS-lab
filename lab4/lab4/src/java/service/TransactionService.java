/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import domain.Route;
import domain.Flight;
import domain.Employee;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

@Stateless
public class TransactionService {
    
    @EJB
    private RouteService routeService;
    
    @EJB
    private FlightService flightService;
    
    @EJB
    private EmployeeService employeeService;
    
    @Transactional
    public void successTr(Route route, Flight flight, Employee employee) {
        routeService.create(route);
        flightService.create(flight);
        employeeService.create(employee);
    }
    
    @Transactional
    public void rollBackTr(Route route, Flight flight, Employee employee) {
        routeService.create(route);
        flightService.create(flight);
        employeeService.rollBack(employee);
    }
    
    @Transactional
    public void throwEx(Route route, Flight flight, Employee employee) {
        routeService.create(route);
        employeeService.create(employee);
        flightService.throwExceprion(flight);
    }
    
    @Transactional
    public void rollBackNoTr(Route route, Flight flight, Employee employee) {
        flightService.create(flight);
        routeService.rollBack(route);
        employeeService.noTransact(employee);
    }
    
    @Transactional
    public void newTr(Flight flight, Employee employee) {
        flightService.transact(flight);
        employeeService.throwException(employee);
    }
}
