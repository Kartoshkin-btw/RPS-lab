/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import model.Flight;
import java.util.List;

/**
 *
 * @author utkin
 */
public interface FlightService {
    public List<Flight> getAll();
    public void create(Flight flight);
    public void edit(Flight flight);
    public void remove(Flight flight);
    public Flight getById(int id);
}
