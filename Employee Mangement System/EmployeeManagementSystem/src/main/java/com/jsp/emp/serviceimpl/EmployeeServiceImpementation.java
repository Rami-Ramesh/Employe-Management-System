package com.jsp.emp.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.jsp.emp.dto.EmployeeRequest;
import com.jsp.emp.dto.EmployeeResponse;
import com.jsp.emp.entity.Employee;
import com.jsp.emp.exception.DatabaseEmptyException;
import com.jsp.emp.exception.EmployeeNotFoundByEmailException;
import com.jsp.emp.exception.EmployeeNotFoundByIdException;
import com.jsp.emp.exception.EmployeeNotFoundByNameException;
import com.jsp.emp.exception.EmployeeNotFoundByPhonoNumberException;
import com.jsp.emp.repository.EmployeeRepository;
import com.jsp.emp.service.EmployeeService;
import com.jsp.emp.utility.ResponseStructure;

@Service
public class EmployeeServiceImpementation implements EmployeeService 
{

	@Autowired
	EmployeeRepository empRepository;

	@Override
	public ResponseEntity<ResponseStructure<EmployeeResponse>> saveEmployee(EmployeeRequest employeeRequest)
	{

		Employee employee=new Employee();
		
		employee.setEmployeeName(employeeRequest.getEmployeeName());
		employee.setEmployeeSalary(employeeRequest.getEmployeeSalary());
		employee.setEmployeeEmail(employeeRequest.getEmployeeEmail());
		employee.setEmployeeDesignation(employeeRequest.getEmployeeDesignation());
		employee.setEmployeePhoNumber(employeeRequest.getEmployeePhoNumber());


		Employee databaseEmployee = empRepository.save(employee);

		EmployeeResponse employeeResponse=new EmployeeResponse();
		
		employeeResponse.setEmployeeId(databaseEmployee.getEmployeeId());	
		employeeResponse.setEmployeeName(databaseEmployee.getEmployeeName());
		employeeResponse.setEmployeeDesignation(databaseEmployee.getEmployeeDesignation());


		ResponseStructure<EmployeeResponse> structure=new ResponseStructure<EmployeeResponse>();

		structure.setStatus(HttpStatus.CREATED.value());
		structure.setMessage("Employee Data Saved Succesfully!!!!!!!!!");
		structure.setData(employeeResponse);

		return new ResponseEntity<ResponseStructure<EmployeeResponse>>(structure,HttpStatus.CREATED);

	}

	@Override
	public ResponseEntity<ResponseStructure<EmployeeResponse>> updateEmployeeById(EmployeeRequest employeeRequest,
			int employeeId) {

		Optional<Employee> optional = empRepository.findById(employeeId);


		if(optional.isPresent())
		{

			Employee databaseEmployee = optional.get();

			databaseEmployee.setEmployeeName(employeeRequest.getEmployeeName());
			databaseEmployee.setEmployeeSalary(employeeRequest.getEmployeeSalary());
			databaseEmployee.setEmployeeEmail(employeeRequest.getEmployeeEmail());
			databaseEmployee.setEmployeeDesignation(employeeRequest.getEmployeeDesignation());
			databaseEmployee.setEmployeePhoNumber(employeeRequest.getEmployeePhoNumber());


			Employee updatedEmployee = empRepository.save(databaseEmployee);



			EmployeeResponse employeeResponse=new EmployeeResponse();
			employeeResponse.setEmployeeId(updatedEmployee.getEmployeeId());	
			employeeResponse.setEmployeeName(updatedEmployee.getEmployeeName());
			employeeResponse.setEmployeeDesignation(updatedEmployee.getEmployeeDesignation());


			ResponseStructure<EmployeeResponse> structure=new ResponseStructure<EmployeeResponse>();

			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("Employee Data Updated Succesfully!!!!!!!!!");
			structure.setData(employeeResponse);

			return new ResponseEntity<ResponseStructure<EmployeeResponse>>(structure,HttpStatus.OK);

		}
		else
			throw new EmployeeNotFoundByIdException("Employee Data Not Present...!!!!!");
	}

	@Override
	public ResponseEntity<ResponseStructure<EmployeeResponse>> deleteEmployeeById(int employeeId) {

		Optional<Employee> optional = empRepository.findById(employeeId);


		if(optional.isPresent())
		{

			Employee databaseEmployee = optional.get();
			
			EmployeeResponse employeeResponse=new EmployeeResponse();
			employeeResponse.setEmployeeId(databaseEmployee.getEmployeeId());	
			employeeResponse.setEmployeeName(databaseEmployee.getEmployeeName());
			employeeResponse.setEmployeeDesignation(databaseEmployee.getEmployeeDesignation());

			empRepository.delete(databaseEmployee);

			ResponseStructure<EmployeeResponse> structure=new ResponseStructure<EmployeeResponse>();

			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("Employee Data Deleted Succesfully!!!!!!!!!");
			structure.setData(employeeResponse);

			return new ResponseEntity<ResponseStructure<EmployeeResponse>>(structure,HttpStatus.OK);

		}
		else
			throw new EmployeeNotFoundByIdException("Employee Data Not Present...!!!!!");
	}

	@Override
	public ResponseEntity<ResponseStructure<EmployeeResponse>> findEmployeeById(int employeeId) {
		Optional<Employee> optional = empRepository.findById(employeeId);


		if(optional.isPresent())
		{

			Employee databaseEmployee = optional.get();

			EmployeeResponse employeeResponse=new EmployeeResponse();
			employeeResponse.setEmployeeId(databaseEmployee.getEmployeeId());	
			employeeResponse.setEmployeeName(databaseEmployee.getEmployeeName());
			employeeResponse.setEmployeeDesignation(databaseEmployee.getEmployeeDesignation());

			ResponseStructure<EmployeeResponse> structure=new ResponseStructure<EmployeeResponse>();

			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("Employee Data Found Succesfully!!!!!!!!!");
			structure.setData(employeeResponse);

			return new ResponseEntity<ResponseStructure<EmployeeResponse>>(structure,HttpStatus.FOUND);

		}
		else
			throw new EmployeeNotFoundByIdException("Employee Data Not Present...!!!!!");
	}

	@Override
	public ResponseEntity<ResponseStructure<List<EmployeeResponse>>> findAllEmployeeById() {

		List<Employee> employeelist = empRepository.findAll();

		if(employeelist.isEmpty())
		{
			throw new DatabaseEmptyException("Employee Data Not Present....!!!!!!");
		}
		else
		{
			List<EmployeeResponse>  employeeResponseList=new ArrayList<EmployeeResponse>();

			for (Employee employee : employeelist) {
				EmployeeResponse employeeResponse=new EmployeeResponse();
				employeeResponse.setEmployeeId(employee.getEmployeeId());	
				employeeResponse.setEmployeeName(employee.getEmployeeName());
				employeeResponse.setEmployeeDesignation(employee.getEmployeeDesignation());
				employeeResponseList.add(employeeResponse);
			}
			ResponseStructure<List<EmployeeResponse>> structure=new ResponseStructure<List<EmployeeResponse>>();

			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("Employee Data Found Succesfully!!!!!!!!!");
			structure.setData(employeeResponseList);

			return new ResponseEntity<ResponseStructure<List<EmployeeResponse>>>(structure,HttpStatus.FOUND);
		}


	}

	@Override
	public ResponseEntity<ResponseStructure<EmployeeResponse>> findByemployeeName(String employeeName) {
		Employee databaseEmployee = empRepository.findByemployeeName(employeeName);


		if(databaseEmployee!=null)
		{
			EmployeeResponse employeeResponse=new EmployeeResponse();
			employeeResponse.setEmployeeId(databaseEmployee.getEmployeeId());	
			employeeResponse.setEmployeeName(databaseEmployee.getEmployeeName());
			employeeResponse.setEmployeeDesignation(databaseEmployee.getEmployeeDesignation());

			ResponseStructure<EmployeeResponse> structure=new ResponseStructure<EmployeeResponse>();

			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("Employee Data Found By Name Succesfully!!!!!!!!!");
			structure.setData(employeeResponse);

			return new ResponseEntity<ResponseStructure<EmployeeResponse>>(structure,HttpStatus.FOUND);

		}
		else
			throw new EmployeeNotFoundByNameException("Employee Data Not Present...!!!!!");
	}

	@Override
	public ResponseEntity<ResponseStructure<EmployeeResponse>> findByemployeeEmail(String employeeEmail) {
		Employee databaseEmployee = empRepository.findByemployeeEmail(employeeEmail);


		if(databaseEmployee!=null)
		{
			EmployeeResponse employeeResponse=new EmployeeResponse();
			employeeResponse.setEmployeeId(databaseEmployee.getEmployeeId());	
			employeeResponse.setEmployeeName(databaseEmployee.getEmployeeName());
			employeeResponse.setEmployeeDesignation(databaseEmployee.getEmployeeDesignation());

			ResponseStructure<EmployeeResponse> structure=new ResponseStructure<EmployeeResponse>();

			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("Employee Data Found By Email Succesfully!!!!!!!!!");
			structure.setData(employeeResponse);

			return new ResponseEntity<ResponseStructure<EmployeeResponse>>(structure,HttpStatus.FOUND);

		}
		else
			throw new EmployeeNotFoundByEmailException("Employee Data Not Present...!!!!!");
	}

	@Override
	public ResponseEntity<ResponseStructure<EmployeeResponse>> findByemployeePhoNumber(long employeePhoNumber) {
		Employee databaseEmployee = empRepository.findByemployeePhoNumber(employeePhoNumber);


		if(databaseEmployee!=null)
		{
			EmployeeResponse employeeResponse=new EmployeeResponse();
			employeeResponse.setEmployeeId(databaseEmployee.getEmployeeId());	
			employeeResponse.setEmployeeName(databaseEmployee.getEmployeeName());
			employeeResponse.setEmployeeDesignation(databaseEmployee.getEmployeeDesignation());

			ResponseStructure<EmployeeResponse> structure=new ResponseStructure<EmployeeResponse>();

			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("Employee Data Found By Phone Number Succesfully!!!!!!!!!");
			structure.setData(employeeResponse);

			return new ResponseEntity<ResponseStructure<EmployeeResponse>>(structure,HttpStatus.FOUND);

		}
		else
			throw new EmployeeNotFoundByPhonoNumberException("Employee Data Not Present...!!!!!");
	}

	@Override
	public ResponseEntity<ResponseStructure<List<EmployeeResponse>>> findAllByemployeeDesignation(
			String employeeDesignation) 
	{
		List<Employee> employeelist = empRepository.findAllByemployeeDesignation(employeeDesignation);

		if(employeelist.isEmpty())
		{
			throw new DatabaseEmptyException("Employee  Data Not Present....!!!!!!");
		}
		else
		{

			List<EmployeeResponse>  employeeResponseList=new ArrayList<EmployeeResponse>();

			for (Employee employee : employeelist) {
				EmployeeResponse employeeResponse=new EmployeeResponse();
				employeeResponse.setEmployeeId(employee.getEmployeeId());	
				employeeResponse.setEmployeeName(employee.getEmployeeName());
				employeeResponse.setEmployeeDesignation(employee.getEmployeeDesignation());
				employeeResponseList.add(employeeResponse);
			}
			ResponseStructure<List<EmployeeResponse>> structure=new ResponseStructure<List<EmployeeResponse>>();

			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("Employees Data Found By Designation Succesfully!!!!!!!!!");
			structure.setData(employeeResponseList);

			return new ResponseEntity<ResponseStructure<List<EmployeeResponse>>>(structure,HttpStatus.FOUND);
		}


	}

	@Override
	public ResponseEntity<ResponseStructure<List<String>>> getAllEmailBySalary(double salary) {

		List<String> employeelist = empRepository.getAllEmailBySalary(salary);
		if(employeelist.isEmpty())
		{
			throw new DatabaseEmptyException("Employee Data Not Present....!!!!!!");
		}
		else
		{
			ResponseStructure<List<String>> structure=new ResponseStructure<List<String>>();
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("Employees Datas Found By Salary Succesfully!!!!!!!!!");
			structure.setData(employeelist);
			return new ResponseEntity<ResponseStructure<List<String>>>(structure,HttpStatus.FOUND);
		}
	}

}

