package com.luv2code.web.jdbc;

public class Employee {

	String id;
	String name;
	String salary;
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getSalary() {
		return salary;
	}
	public Employee(String id, String name, String salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	
	
}
