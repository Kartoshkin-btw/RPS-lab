package org.example.controllers;

import com.sun.tools.internal.ws.processor.model.Model;
import org.example.DAO.EmployeeDAO;
import org.example.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public class EmployeeController {
    @Autowired
    EmployeeDAO dao;
    @RequestMapping("/viewEmployee")
    public String viewEmployees(Model model){
        List<Employee> list = dao.getEmployees();
        model.setProperty("list", list);
        return  "viewEmployees";
    }
    @RequestMapping("/employeeForm")
    public String employeeForm(Model model){
        model.setProperty("command", new Employee());
        return "employeeForm";
    }
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(@ModelAttribute("emp") Employee employee){
        dao.insert(employee);
        return "redirect:/viewEmployees";
    }
    @RequestMapping("/index")
    public String returnIndex(Model model){
        return "../../index";
    }
    @RequestMapping(value = "/editEmployee/{id}")
    public String edit(@PathVariable int id, Model model){
        Employee employee = dao.getById(id);
        model.setProperty("command", employee);
        return "editForm";
    }
    @RequestMapping(value = "/editsave", method = RequestMethod.POST)
    public String editsave(@ModelAttribute("emp")Employee employee){
        dao.update(employee);
        return "redirect:/viewEmployees";
    }
    @RequestMapping(value = "/deleteEmployee/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable int id){
        dao.delete(id);
        return "redirect:/viewEmployees";
    }
}
