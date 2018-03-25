package com.Restful.webservices.example01;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.WebMvcProperties.LocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class Example01Application {

	public static void main(String[] args) {
		SpringApplication.run(Example01Application.class, args);
	}

	//this is to set the default locale
	@Bean
	public SessionLocaleResolver localeResolver() {
		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}

	//	storing all the languages in REsourceBundle
	@Bean 
	public ResourceBundleMessageSource bundleMessageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		//we set the base name which is messages here cause files will be messages_fr 
		//or  messages_sp or messages.ar etc it will be connected to the Locale to guess what file to use 
		messageSource.setBasename("messages");
		return messageSource;
	}
}
