package com.jsp.emp.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jsp.emp.dto.EmployeeRequest;
import com.jsp.emp.dto.EmployeeResponse;
import com.jsp.emp.service.EmployeeService;
import com.jsp.emp.utility.ResponseStructure;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping
	public ResponseEntity<ResponseStructure<EmployeeResponse>> saveEmployee(@RequestBody @Valid   EmployeeRequest employeeRequest){
		return employeeService.saveEmployee(employeeRequest);
	}
	
	@PutMapping("/{employeeId}")
	public ResponseEntity<ResponseStructure<EmployeeResponse>> updateEmployeeById(@RequestBody @Valid  EmployeeRequest employeeRequest,
		@PathVariable	int employeeId){
		return employeeService.updateEmployeeById(employeeRequest, employeeId);

	}
	
	@DeleteMapping("/{employeeId}")
	public ResponseEntity<ResponseStructure<EmployeeResponse>> deleteEmployeeById( @PathVariable int employeeId) {
		return employeeService.deleteEmployeeById(employeeId);
	}

	@GetMapping("/emp/{employeeId}")
	public ResponseEntity<ResponseStructure<EmployeeResponse>> findEmployeeById(@PathVariable int employeeId) {
		return employeeService.findEmployeeById(employeeId);
	}

	@GetMapping
	public ResponseEntity<ResponseStructure<List<EmployeeResponse>>> findAllEmployeeById() {
		return employeeService.findAllEmployeeById() ;
	}

	@GetMapping("/name/{employeeName}")
	public ResponseEntity<ResponseStructure<EmployeeResponse>> findByemployeeName( @PathVariable String employeeName) {
		return employeeService.findByemployeeName(employeeName);
	}
	
	@GetMapping("/email/{employeeEmail}")
	public ResponseEntity<ResponseStructure<EmployeeResponse>> findByemployeeEmail(@PathVariable String employeeEmail) {
		return employeeService.findByemployeeEmail(employeeEmail);
	}

	@GetMapping("/phone/{employeePhoNumber}")
	public ResponseEntity<ResponseStructure<EmployeeResponse>> findByemployeePhoNumber(@PathVariable long employeePhoNumber) {
		return employeeService.findByemployeePhoNumber(employeePhoNumber);
	}

	@GetMapping("/des/{employeeDesignation}")
	public ResponseEntity<ResponseStructure<List<EmployeeResponse>>> findAllByemployeeDesignation(
			@PathVariable String employeeDesignation) {
		return employeeService.findAllByemployeeDesignation(employeeDesignation);
	}

	@GetMapping("/sal/{salary}")
	public ResponseEntity<ResponseStructure<List<String>>> getAllEmailBySalary(@PathVariable double salary) {

		return employeeService.getAllEmailBySalary(salary);
	}


}

