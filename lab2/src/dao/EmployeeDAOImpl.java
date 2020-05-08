package dao;
import models.Employee;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class EmployeeDAOImpl implements EmployeeDAO {
    private static String url;
    private static String username;
    private static String password;
    private  String sql;

    @PostConstruct
    private void init(){
        url = "jdbc:mysql://localhost:3306/spring1?useUnicode=true&serverTimezone=UTC";
        username = "root";
        password = "root";
    }

    @Override
    public void insertEmployee(Employee employee) {
        sql = "insert into employee(name, age, role) values (?, ?, ?);";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, employee.getName());
            stmt.setInt(2, employee.getAge());
            stmt.setString(3, employee.getRole());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void updateEmployee(Employee employee) {
        sql = "UPDATE goods SET name = " + employee.getName() + ", age="+ employee.getAge() +", role="+ employee.getRole() + "WHERE id=" + employee.getId() + ";";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            conn.prepareStatement(sql).executeUpdate();
        } catch (Exception e){
            System.out.println(e);
        }

    }

    @Override
    public void deleteEmployee(int id) {
        sql = "delete from employee where id=" + id + ";";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            conn.prepareStatement(sql).executeUpdate();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    public Employee getEmployeeById(int id) {
        Employee result = null;
        sql = "select * from employee where id= " + id + ";";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()){
                result = new Employee(
                        rs.getInt("Id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("role")
                );
            }
        } catch (Exception e){
            System.out.println(e);
        } return result;

    }

    @Override
    public List<Employee> ListOfEmployees() {
        List<Employee> result = new ArrayList<>();
        sql = "select * from employee;";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()){
                Employee employee = new Employee(
                        rs.getInt("Id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("role")
                );
                result.add(employee);
            }
            conn.close();
        } catch (Exception e){
            System.out.println(e);
        } return result;
    }
}
