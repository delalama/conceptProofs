package com.aspects.aspects.service;

import com.aspects.aspects.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private final List<Employee> employees = new ArrayList<>();

    public Employee createEmployee(String name, String empId) {
        Employee employee = new Employee(empId, name);

        if (employee != null) {
            employees.add(employee);
        }

        return new Employee(empId, name);
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public void deleteEmployee(String empId) {

    }
}