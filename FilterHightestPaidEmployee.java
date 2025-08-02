package com.am.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Employee1
{
	String name ;
	Integer age;
	Double salary;
	String departmentName;
	
	public Employee1(String name, Integer age, Double salary,String departmentName) 
	{
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.departmentName =departmentName ;
	}

	public String getName() {
		return name;
	}

	public Integer getAge() {
		return age;
	}

	public Double getSalary() {
		return salary;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", salary=" + salary + ", departmentName=" + departmentName
				+ "]";
	}

	
	
}

public class FilterHightestPaidEmployee
{
	public static void main(String[] args) 
	{
		List<Employee1> empList = new ArrayList<>();
		
		empList.add(new Employee1("Karan" ,23, 25000.0,"Seles"));
		
		empList.add(new Employee1("Akshay" ,26, 26000.0,"Account"));
		
		empList.add(new Employee1("Sandesh" ,25, 26000.0, "Sales"));
		
		empList.add(new Employee1("Gaurav" ,27, 25000.0,"Account"));
		
		empList.add(new Employee1("Kunal" ,27, 23000.0,"Account"));
		
		empList.add(new Employee1("Nilesh" ,25, 23000.0, "Sales"));
		
		double highSal = 0.0 ;
		List<Employee1> salesDept = empList.stream().filter( e ->  e.getDepartmentName().equals("Sales")).collect(Collectors.toList());
		List<Employee1> accountDept = empList.stream().filter( e ->  e.getDepartmentName().equals("Account")).collect(Collectors.toList());
		
		
	}
}
