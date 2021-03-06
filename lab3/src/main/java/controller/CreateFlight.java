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
import service.FlightService;
import service.RouteService;

/**
 *
 * @author utkin
 */
public class CreateFlight extends HttpServlet {
    @EJB
    RouteService routeService;
    
    @EJB
    FlightService flightService;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CreateFlight</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreateFlight at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Route> routes = routeService.getAll();
            request.setAttribute("routes", routes);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("CreateFlight.jsp");
            requestDispatcher.forward(request, response);
        } catch (IOException | ServletException e) { 
            throw new ServletException(e.getMessage()); 
        }  

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Flight flight = new Flight();
        flight.setDate(request.getParameter("date"));
        flight.setTime(request.getParameter("time"));
        Route route = routeService.getById(Integer.parseInt(request.getParameter("route")));
        flight.setId_Route(route);
        flightService.create(flight);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request, response);

    }
}
