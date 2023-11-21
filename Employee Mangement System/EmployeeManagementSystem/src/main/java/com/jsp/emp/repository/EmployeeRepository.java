package com.jsp.emp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.emp.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{
	public Employee findByemployeeName(String employeeName);
	public Employee findByemployeeEmail(String employeeEmail);
	public Employee findByemployeePhoNumber(long employeePhoNumber);
	public List<Employee> findAllByemployeeDesignation(String employeeDesignation);
	@Query("select  emp.employeeEmail from Employee emp where emp.employeeSalary=?1")
	public List<String> getAllEmailBySalary(double salary);
}
