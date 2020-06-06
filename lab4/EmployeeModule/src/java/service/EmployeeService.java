/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import domain.Library;
import java.util.List;

public interface EmployeeService {
    public List<Employee> findAll();

    public Employee find(int id);
    
    public void create(Employee employee);
    
    public void edit(Employee employee);
    
    public void remove(Employee employee);
    
    public void throwException(Employee employee);
    
    public void rollBack(Employee employee);
    
    public void noTransact(Employee employee);
    
    public void newTransact(Employee employee);
}
