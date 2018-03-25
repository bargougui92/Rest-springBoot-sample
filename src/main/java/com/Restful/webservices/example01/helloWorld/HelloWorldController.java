package com.Restful.webservices.example01.helloWorld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@Autowired
	private MessageSource bundleMessageSource;
	
	@GetMapping("/hello-world-internationalized")
	public String helloWorldI18n(@RequestHeader(name="Accept-Language", required=false) Locale locale) //putting language in header is not required
	{
		return bundleMessageSource.getMessage("good.morning.message", null, locale);
	}
	@GetMapping("/hello-world")
	public String helloWorld() {
		return "hello";
	}

	//hello-world-bean
	@GetMapping("/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("bean") ;
	}
	
	//hello-world-bean/path-variable/in28minuts
	@GetMapping("/hello-world-bean/path-variable/{name}")
	public HelloWorldBean helloWorldBean(@PathVariable String name) {
		return new HelloWorldBean(String.format("hi, %s", name));
	}
}
