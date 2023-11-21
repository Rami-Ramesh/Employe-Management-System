package com.jsp.emp.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EmployeeRequest 
{
	@NotNull(message="Employee name con't be null")
	private String employeeName;
	
	@NotNull(message="Employee Salary con't be null")
	private double employeeSalary;
	
	@NotBlank(message="Employee Email con't be blank")
	private String employeeEmail;
	
	@NotNull(message="Employee Designation con't be null")
	private String employeeDesignation;
	
	@Min(value=6000000000l,message="Phone Number cannot start below '6'!!")
	@Max(value=9999999999l,message="Phone Number cannot be above below '99999999999'!!")
	private long employeePhoNumber;
	
	
	
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public double getEmployeeSalary() {
		return employeeSalary;
	}
	public void setEmployeeSalary(double employeeSalary) {
		this.employeeSalary = employeeSalary;
	}
	public String getEmployeeEmail() {
		return employeeEmail;
	}
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}
	public String getEmployeeDesignation() {
		return employeeDesignation;
	}
	public void setEmployeeDesignation(String employeeDesignation) {
		this.employeeDesignation = employeeDesignation;
	}
	public long getEmployeePhoNumber() {
		return employeePhoNumber;
	}
	public void setEmployeePhoNumber(long employeePhoNumber) {
		this.employeePhoNumber = employeePhoNumber;
	}
}
