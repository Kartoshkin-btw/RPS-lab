package dao;
import models.Employee;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface EmployeeDAO {
    void insertEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(int id);
    Employee getEmployeeById(int id);
    List<Employee> ListOfEmployees();
}
