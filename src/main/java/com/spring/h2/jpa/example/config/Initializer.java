package com.spring.h2.jpa.example.config;

import java.time.Instant;
import java.util.Collections;
import java.util.Date;
import java.util.stream.Stream;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.spring.h2.jpa.example.model.Department;
import com.spring.h2.jpa.example.model.Employee;
import com.spring.h2.jpa.example.repository.DepartmentRepository;
import com.spring.h2.jpa.example.repository.EmployeeRepository;

@Component
public class Initializer implements CommandLineRunner {

	private final DepartmentRepository depRepo;
	
	private final EmployeeRepository  empRepo;

	public Initializer(DepartmentRepository depRepo,EmployeeRepository  empRepo) {
		this.depRepo = depRepo;
		this.empRepo = empRepo;
	}

	@Override
	public void run(String... args) throws Exception {
		Stream.of("Dep1", "Dep2", "Dep3").forEach(name -> depRepo.save(new Department(name)));
		
		
		Employee e1 = Employee.builder().firstName("Dina").lastName("Zaid").phoneNumber("566399919").hireDate(new Date()).salary(100).email("eng.dinazaid@gmail.com").build();
		Employee e2 = Employee.builder().firstName("Mohammed").lastName("Hamouda").phoneNumber("181229").hireDate(new Date()).salary(100).email("eng.Mohammed@gmail.com").build();
		Employee e3 = Employee.builder().firstName("Eman").lastName("Zaid").phoneNumber("1234").hireDate(new Date()).salary(100).email("eng.nanazaid@gmail.com").build();
		Employee e4 = Employee.builder().firstName("Yasmeen").lastName("Zaid").phoneNumber("5678").hireDate(new Date()).salary(100).email("eng.yasmeenzaid@gmail.com").build();
		Employee e5 = Employee.builder().firstName("Ahmed").lastName("Zaid").phoneNumber("9101112").hireDate(new Date()).salary(100).email("eng.ahmedzaid@gmail.com").build();
		Employee e6 = Employee.builder().firstName("Maryam").lastName("Mohammed").phoneNumber("932017").hireDate(new Date()).salary(100).email("eng.MaryamHamouda@gmail.com").build();
		
		Department dep1 = depRepo.findByName("Dep1");
		e1.setDepartment(dep1);
		Department dep2 = depRepo.findByName("Dep2");
		e2.setDepartment(dep2);
		Department dep3 = depRepo.findByName("Dep3");
		e3.setDepartment(dep3);
		e4.setDepartment(dep1);
		e5.setDepartment(dep2);
		e6.setDepartment(dep3);
		
	
		
		
		e1= empRepo.save(e1);
		e2=empRepo.save(e2);
		e3=empRepo.save(e3);
		e4=empRepo.save(e4);
		e5=empRepo.save(e5);
		e6=empRepo.save(e6);

		e2.setManagerId(e1.getId());
		e3.setManagerId(e1.getId());
		e4.setManagerId(e1.getId());
		e5.setManagerId(e2.getId());
		e6.setManagerId(e3.getId());

		empRepo.save(e2);
		empRepo.save(e3);
		empRepo.save(e4);
		empRepo.save(e5);
		empRepo.save(e6);
		
	 dep1.setManager(e1);
        depRepo.save(dep1);
	        dep2.setManager(e2);
	        depRepo.save(dep2);
	        
	        dep3.setManager(e3);
	        depRepo.save(dep3);

	}

}
