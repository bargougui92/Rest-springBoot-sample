package com.Restful.webservices.example01.helloWorld;

public class HelloWorldBean {
	private String message;
	
	public HelloWorldBean(String message) {
		this.setMessage(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
