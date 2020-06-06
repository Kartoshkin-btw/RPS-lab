/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import domain.Flight;
import java.util.List;

public interface FlightService {
    public List<Flight> findAll();

    public Flight find(int id);
    
    public void create(Flight flight);
    
    public void edit(Flight flight);
    
    public void remove(Flight flight);
    
    public void throwExceprion(Flight flight);
    
    public void rollBack(Flight flight);
    
    public void noTransact(Flight flight);
    
    public void transact(Flight flight);
}
