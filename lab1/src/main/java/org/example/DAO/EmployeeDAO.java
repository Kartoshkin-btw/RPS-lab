package org.example.DAO;

import org.example.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

@Component
public class EmployeeDAO {
    @Autowired
    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }
    public int insert(Employee employee){
        String sql = "INSERT INTO Employee(name, age, role) values(?,?,?)";
        Object[] params = {employee.getName(), employee.getAge(), employee.getRole()};
        int[] types = {Types.VARCHAR, Types.INTEGER, Types.VARCHAR};
        int rows = template.update(sql,params,types);
        return rows;
    }
    public int update(Employee employee){
        String sql = "UPDATE Employee SET name = ?, age = ?, role = ? WHERE id = ?";
        Object[] params = {employee.getName(), employee.getAge(), employee.getRole(), employee.getId()};
        int[] types = {Types.VARCHAR, Types.INTEGER, Types.VARCHAR, Types.INTEGER};
        int rows = template.update(sql,params,types);
        return rows;
    }
    public int delete(int id){
        String sql = "DELETE FROM Employee WHERE id = ?";
        Object[] params = {id};
        int[] types = {Types.INTEGER};
        int rows = template.update(sql,params,types);
        return rows;
    }
    public Employee getById(int id){
        String sql = "SELECT * FROM Employee WHERE id = ?";
        return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<Employee>(Employee.class));
    }
    public List<Employee> getEmployees(){
        String sql = "SELECT * FROM Employee";
        List<Employee> list = template.query(sql, new EmployeeRowMapper());
        return list;
    }
    public class EmployeeResultSetExtractor implements ResultSetExtractor {
        @Override
        public Object extractData(ResultSet rs) throws SQLException {
            Employee employee = new Employee();
            employee.setId(rs.getInt(1));
            employee.setName(rs.getString(2));
            employee.setAge(rs.getInt(3));
            employee.setRole(rs.getString(4));
            return employee;
        }
    }
    public class EmployeeRowMapper implements RowMapper {
        @Override
        public Object mapRow(ResultSet rs, int line) throws SQLException {
            EmployeeResultSetExtractor extractor = new EmployeeResultSetExtractor();
            return extractor.extractData(rs);
        }
    }
}
