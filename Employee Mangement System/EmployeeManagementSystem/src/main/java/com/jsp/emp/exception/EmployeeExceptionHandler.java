package com.jsp.emp.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jsp.emp.utility.ErrorStructure;
@RestControllerAdvice
public class EmployeeExceptionHandler extends ResponseEntityExceptionHandler
{	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		List<ObjectError> allErrors = ex.getAllErrors();
		Map<String,String> errors =new HashMap<String,String>();
		
		for (ObjectError objectError : allErrors) 
		{
			FieldError fieldError=(FieldError) objectError;
			
			errors.put(fieldError.getDefaultMessage(),fieldError.getField());
		}
		return new ResponseEntity<Object>(errors,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler
	public ResponseEntity<ErrorStructure> EmployeeNotFoundById(EmployeeNotFoundByIdException ex )
	{
		
		ErrorStructure errorStructure=new ErrorStructure();
		errorStructure.setMessage(ex.getMessage());
		errorStructure.setRootcuase("Employee is Not Present with Request Id!!!!!!!!");
		errorStructure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ErrorStructure>(errorStructure,HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler
	public ResponseEntity<ErrorStructure> EmployeeNotFoundByEmail(EmployeeNotFoundByEmailException ex )
	{
		
		ErrorStructure errorStructure=new ErrorStructure();
		errorStructure.setMessage(ex.getMessage());
		errorStructure.setRootcuase("Employee  is Not Present with Request Email!!!!!!!!");
		errorStructure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ErrorStructure>(errorStructure,HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler
	public ResponseEntity<ErrorStructure> EmployeeNotFoundByName(EmployeeNotFoundByNameException ex )
	{
		
		ErrorStructure errorStructure=new ErrorStructure();
		errorStructure.setMessage(ex.getMessage());
		errorStructure.setRootcuase("Employee is Not Present with Request Name!!!!!!!!");
		errorStructure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ErrorStructure>(errorStructure,HttpStatus.NOT_FOUND);	
	}
	@ExceptionHandler
	public ResponseEntity<ErrorStructure> EmployeeNotFoundByPhonoNumber(EmployeeNotFoundByPhonoNumberException ex )
	{
		
		ErrorStructure errorStructure=new ErrorStructure();
		errorStructure.setMessage(ex.getMessage());
		errorStructure.setRootcuase("Employee is Not Present with Request PhonoNumber!!!!!!!!");
		errorStructure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ErrorStructure>(errorStructure,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorStructure> DatabaseEmpty(DatabaseEmptyException ex )
	{
		
		ErrorStructure errorStructure=new ErrorStructure();
		errorStructure.setMessage(ex.getMessage());
		errorStructure.setRootcuase("Database is Empty....!!!!!!!!");
		errorStructure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ErrorStructure>(errorStructure,HttpStatus.NOT_FOUND);
		
	}
	
	
	
	
	
	
	
}
