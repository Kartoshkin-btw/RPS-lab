/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import domain.Route;
import java.util.List;

public interface RouteService {
    public List<Route> findAll();
       
    public Route find(int id);
       
    public void create(Route route);
       
    public void edit(Route route);
       
    public void remove(Route route);

    public void throwExceprion(Route route);

    public void rollBack(Route route);
       
    public void noTrastact(Route route);
       
    public void transact(Route route);
}
