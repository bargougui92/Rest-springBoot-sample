package com.Restful.webservices.example01.user;

import java.sql.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import javax.xml.crypto.Data;

import io.swagger.annotations.ApiModelProperty;

public class User {
	private Integer id;
	
	@Size(min=2, message="Name should have atleast 2 characters")
	@ApiModelProperty(notes="Name should have at least 2 characters")
	private String name;
	
	@Past
	//you can find @ApiModelProperty and all the other swagger annotation in the swagger-annotation jar file
	@ApiModelProperty(notes="Birth date should be in the past") //this will be shown in description of the property in swaggerFile
	private java.util.Date birthday;
	
	public Integer getId() {
		return id;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthday=" + birthday + "]";
	}
	public User(Integer id , String name, java.util.Date date) {
		super();
		this.id = id;
		this.name = name;
		this.birthday = date;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public User() {
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public java.util.Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
}
