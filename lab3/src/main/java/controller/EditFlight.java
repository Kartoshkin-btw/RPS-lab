/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Flight;
import model.Route;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.RouteService;
import service.FlightService;

/**
 *
 * @author utkin
 */
public class EditFlight extends HttpServlet{
    @EJB
    RouteService routeService;
    
    @EJB
    FlightService flightService;
    Flight flight;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EditFlight</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditFlight at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        flight = flightService.getById(id);
        request.setAttribute("flight", flight);
        List<Route> routes = routeService.getAll();
        request.setAttribute("routes", routes);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("EditFlight.jsp");
        requestDispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        flight.setDate(request.getParameter("date"));       
        flight.setTime(request.getParameter("time"));  
        Route route = routeService.getById(Integer.parseInt(request.getParameter("route")));
        flight.setId_Route(route);
        flightService.edit(flight);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request, response);
    }
}
