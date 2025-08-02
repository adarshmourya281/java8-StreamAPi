package com.am.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
class Employee
{
	String name ;
	Integer age;
	Double salary;
	
	public Employee(String name, Integer age, Double salary) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", salary=" + salary + "]";
	}
}

public class IncreaseEmployeeSalary 
{
	public static void main(String[] args) 
	{
		List<Employee> empList = new ArrayList<>();
		
		empList.add(new Employee("Karan" ,23, 25000.0));
		
		empList.add(new Employee("Akshay" ,26, 25000.0));
		
		empList.add(new Employee("Sandesh" ,25, 25000.0));
		
		empList.add(new Employee("Gaurav" ,27, 25000.0));
		
		 empList.stream().filter(e -> e.age > 25 ).collect(Collectors.toList()).forEach(e -> 
		{
			e.salary += e.salary*0.1;
			System.out.println(e);
		});
		
	}
}
