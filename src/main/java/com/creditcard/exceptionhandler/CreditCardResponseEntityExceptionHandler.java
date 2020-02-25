package com.creditcard.exceptionhandler;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//@ControllerAdvice
//@RestController
public class CreditCardResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	    
	    @ExceptionHandler(Exception.class)
	    public final ResponseEntity<ErrorResponse> handleAllExceptions(Exception ex, WebRequest request) {
	    	List<String> details = Arrays.asList(ex.getMessage());
	    	
	    	ErrorResponse error = new ErrorResponse(new Date(), ex.getMessage(),details);
	    	return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	    
		
	    @ExceptionHandler(ConstraintViolationException.class)
	    public final ResponseEntity<ErrorResponse> handleConstraintViolation(ConstraintViolationException ex,WebRequest request)
	    {
	        List<String> details = ex.getConstraintViolations()
	                                    .parallelStream()
	                                    .map(e -> e.getMessage())
	                                    .collect(Collectors.toList());
	        
	        ErrorResponse error = new ErrorResponse(new Date(),"BAD_REQUEST", details);
	        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	    }
}
