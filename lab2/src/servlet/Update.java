package servlet;
import dao.EmployeeDAO;
import models.Employee;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Update extends HttpServlet{
    @EJB
    private EmployeeDAO employeeDAO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            int id = Integer.parseInt(request.getParameter("id"));
            Employee employee = employeeDAO.getEmployeeById(id);
            request.setAttribute("employee", employee);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("updatePage.jsp");
            requestDispatcher.forward(request, response);
        }catch (Exception e) {
            throw new ServletException(e.getMessage());
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeDAO.getEmployeeById(id);
        employee.setName(request.getParameter("name"));
        employee.setAge(Integer.parseInt(request.getParameter("age")));
        employee.setRole(request.getParameter("role"));
        employeeDAO.updateEmployee(employee);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request, response);
    }
}

