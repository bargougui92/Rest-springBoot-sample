package com.Restful.webservices.example01.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//this annotation will show the http status 404 instead of just 500 internal server error
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotfoundException extends RuntimeException {

	public UserNotfoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
