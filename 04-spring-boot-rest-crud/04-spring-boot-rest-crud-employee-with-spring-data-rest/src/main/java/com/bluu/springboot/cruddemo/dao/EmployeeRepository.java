package com.bluu.springboot.cruddemo.dao;

import com.bluu.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(path="memebers")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}   
