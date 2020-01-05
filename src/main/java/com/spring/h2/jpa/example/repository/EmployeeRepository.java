package com.spring.h2.jpa.example.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.spring.h2.jpa.example.model.Employee;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {
	
Employee findByFirstName(String firstName);
}
