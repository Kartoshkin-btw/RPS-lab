/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Employee;
import domain.Route;
import domain.Flight;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.TransactionService;

public class testController extends HttpServlet {
    
    @EJB
    private TransactionService transactionService;

    public void successTr(){
        Employee employee = new Employee();
        employee.setName("Name1");
        employee.setAge(20);
        employee.setRole("Role1");

        Route route = new Route();
        route.setNumber("Number1");
        route.setInstalStop("InstalStop1");
        route.setFinalStop("InstalStop1");

        Flight flight = new Flight();
        flight.setDate("Date1");
        flight.setTime("Time1");
        Route route1 = new Route();
        route1.setID(1);
        flight.setRoute(route1);

        transactionService.successTr(route, flight, employee);
    }
    
    public void rollBackTr(){
        Employee employee = new Employee();
        employee.setName("Name2");
        employee.setAge(20);
        employee.setRole("Role2");

        Route route = new Route();
        route.setNumber("Number2");
        route.setInstalStop("InstalStop2");
        route.setFinalStop("InstalStop2");

        Flight flight = new Flight();
        flight.setDate("Date2");
        flight.setTime("Time2");
        Route route1 = new Route();
        route1.setID(1);
        flight.setRoute(route1);

        transactionService.rollBackTr(route, flight, employee);
    }
    
    public void throwEx(){
        Employee employee = new Employee();
        employee.setName("Name3");
        employee.setAge(20);
        employee.setRole("Role3");

        Route route = new Route();
        route.setNumber("Number3");
        route.setInstalStop("InstalStop3");
        route.setFinalStop("InstalStop3");

        Flight flight = new Flight();
        flight.setDate("Date3");
        flight.setTime("Time3");
        Route route1 = new Route();
        route1.setID(1);
        flight.setRoute(route1);

        transactionService.throwEx(route, flight, employee);
    }
    
    public void rollBackNoTr(){
        Employee employee = new Employee();
        employee.setName("Name4");
        employee.setAge(20);
        employee.setRole("Role4");

        Route route = new Route();
        route.setNumber("Number4");
        route.setInstalStop("InstalStop4");
        route.setFinalStop("InstalStop4");

        Flight flight = new Flight();
        flight.setDate("Date4");
        flight.setTime("Time4");
        Route route1 = new Route();
        route1.setID(1);
        flight.setRoute(route1);

        transactionService.rollBackNoTr(route, flight, employee);
    }
    
    public void newTr() {
        Employee employee = new Employee();
        employee.setName("Name1");
        employee.setAge(20);
        employee.setRole("Role1");

        Flight flight = new Flight();
        flight.setDate("Date1");
        flight.setTime("Time1");
        Route route1 = new Route();
        route1.setID(1);
        flight.setRoute(route1);

        transactionService.newTr(employee, flight);
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet testController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet testController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String test = request.getParameter("test");
        switch(test) {
            case"success":
                successTr();
                break;
            case"rollback":
                rollBackTr();
            case"Exception":
                throwEcxeptionTr();
            case"NoTransact":
                rollBackNoTr();
            case"NewTransact":
                newTr();
                
         processRequest(request, response);       
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
