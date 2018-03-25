package com.Restful.webservices.example01.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.Restful.webservices.example01.user.UserNotfoundException;

@RestControllerAdvice
public class GeneralExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public final ExceptionResponse handleAllExceptions(Exception ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(
        	new Date(),
        	ex.getMessage(),
        	request.getDescription(false)
        	);
        return exceptionResponse; 
    }
    
    @ExceptionHandler(UserNotfoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public final ExceptionResponse handleUserNotFoundExceptions(Exception ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(
        	new Date(),
        	ex.getMessage(),
        	request.getDescription(false)
        	);
        return exceptionResponse; 
    }
    
    @Override
    @ResponseStatus(HttpStatus.BAD_REQUEST)
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
    	
    	  ExceptionResponse exceptionResponse = new ExceptionResponse(
    	        	new Date(),
    	        	"Validation failed",
    	        	ex.getBindingResult().toString()
    	        	);
    	return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);	}
}