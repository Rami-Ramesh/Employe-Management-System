package com.jsp.emp.service;

import java.util.List;
import org.springframework.http.ResponseEntity;
import com.jsp.emp.dto.EmployeeRequest;
import com.jsp.emp.dto.EmployeeResponse;
import com.jsp.emp.entity.Employee;
import com.jsp.emp.utility.ResponseStructure;

public interface EmployeeService {
	public ResponseEntity<ResponseStructure<EmployeeResponse>> saveEmployee(EmployeeRequest employeeRequest);
	public ResponseEntity<ResponseStructure<EmployeeResponse>> updateEmployeeById(EmployeeRequest employeeRequest,int employeeId);
	public ResponseEntity<ResponseStructure<EmployeeResponse>> deleteEmployeeById(int employeeId);
	public ResponseEntity<ResponseStructure<EmployeeResponse>> findEmployeeById(int employeeId);
	public ResponseEntity<ResponseStructure<List<EmployeeResponse>>> findAllEmployeeById();
	public  ResponseEntity<ResponseStructure<EmployeeResponse>> findByemployeeName(String employeeName);
	public  ResponseEntity<ResponseStructure<EmployeeResponse>> findByemployeeEmail(String employeeEmail);
	public  ResponseEntity<ResponseStructure<EmployeeResponse>> findByemployeePhoNumber(long employeePhoNumber);
	public ResponseEntity<ResponseStructure<List<EmployeeResponse>>> findAllByemployeeDesignation(String employeeDesignation);
	public ResponseEntity<ResponseStructure<List<String>>> getAllEmailBySalary(double salary);
	
}
