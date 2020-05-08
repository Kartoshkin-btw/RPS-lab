/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Flight;
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
/**
 *
 * @author utkin
 */
public class ListOfFlights extends HttpServlet {
    @EJB
    FlightService flightService;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
        try {
            List<Flight> result = flightService.getAll();
            request.setAttribute("flights", result);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("ListOfFlights.jsp");
            requestDispatcher.forward(request, response);
        } catch (IOException | ServletException e) {
            throw new ServletException(e.getMessage());
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Flight flight = flightService.getById(id);
        flightService.remove(flight);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request, response);
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ListOfFlights</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ListOfFlights at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }  
    }
}
