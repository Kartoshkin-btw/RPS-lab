/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.Route;

/**
 *
 * @author utkin
 */
public interface RouteService {
    public List<Route> getAll();
    public void create(Route route);
    public void edit(Route route);
    public void remove(Route route);
    public Route getById(int id);
}
