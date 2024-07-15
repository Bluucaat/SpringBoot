package com.bluu.springboot.cruddemo.service;

import com.bluu.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAllEmployees();
    Employee findById(int id);
    Employee save (Employee employee);
    void deleteById(int id);
}
