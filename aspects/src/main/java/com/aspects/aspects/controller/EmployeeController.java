package com.aspects.aspects.controller;

import com.aspects.aspects.model.Employee;
import com.aspects.aspects.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/add/employee", method = RequestMethod.GET)
    public Employee addEmployee(@RequestParam("name") String name, @RequestParam("empId") String empId) {

        return employeeService.createEmployee(name, empId);
    }

    @RequestMapping(value = "/get/allEmployees", method = RequestMethod.GET)
    public List<Employee> addEmployee() {

        return employeeService.getAllEmployees();
    }

    @RequestMapping(value = "/remove/employee", method = RequestMethod.GET)
    public String removeEmployee(@RequestParam("empId") String empId) {

        employeeService.deleteEmployee(empId);

        return "Employee removed";
    }

}
