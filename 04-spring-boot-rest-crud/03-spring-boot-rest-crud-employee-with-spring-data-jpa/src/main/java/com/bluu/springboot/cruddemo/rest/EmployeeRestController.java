package com.bluu.springboot.cruddemo.rest;

import com.bluu.springboot.cruddemo.entity.Employee;
import com.bluu.springboot.cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAllEmployees();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        return employeeService.findById(employeeId);
    }

    @PostMapping("employees")
    public Employee addEmployee(@RequestBody Employee employee){
        //setting id to make sure its newly added, not updated.
        employee.setId(0);
        return employeeService.save(employee);
    }

    @PutMapping("employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @DeleteMapping("employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee employee = employeeService.findById(employeeId);
        if(employee == null){
            throw new RuntimeException("Employee id not found - " + employeeId);
        }
        employeeService.deleteById(employeeId);
        return "Deleted the employee with id - " + employeeId;
    }
}
