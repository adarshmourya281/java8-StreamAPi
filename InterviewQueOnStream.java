package com.akshu.streams;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

record Worker(String name ,Double salary, Date dateOfJoin , String gender)
{
	
}
public class InterviewQueOnStream 
{
	public static void main(String[] args) throws ParseException 
	{
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
	
			Date e4Date = df.parse("12-03-1990");
			Date e1Date = df.parse("01-01-2000");
			Date e2Date = df.parse("15-05-1995");
			Date e3Date = df.parse("10-12-1998");
		
		List<Worker> empList = new ArrayList<>();
		
		empList.add(new Worker("Akshay" , 60000.0, e1Date,"Male"));
		empList.add(new Worker("Deval" , 40000.0, e2Date,"Female"));
		empList.add(new Worker("Karan" , 55000.0, e3Date,"Male"));
		empList.add(new Worker("Prachi" , 60000.0, e4Date,"Female"));
		empList.add(new Worker("Sandesh" , 58000.0, e4Date,"Male"));
		
		//Que 1 : Find the Employee who has the Maximum Salary
			
				//Using map
		Worker highestSalaryEmployee = empList.stream().max((e1, e2) -> e1.salary().compareTo(e2.salary())).get();
		System.out.println("Emplyee With Highest Salary : "+highestSalaryEmployee);
				//Using Method referance
		Double highSalary = empList.stream().max(Comparator.comparingDouble(Worker :: salary)).get().salary();
		System.out.println("List of Employee With Highest Salary");
		empList.stream().filter(e -> e.salary().equals(highSalary)).forEach(System.out :: println);
		System.out.println("");
		
		//Que 2 : Employee With Second Highest Salary
				//Way if Every employee has Different Salary
		 Worker secondHPaidWorker = empList.stream().sorted((e1, e2) -> Double.compare(e2.salary(), e1.salary())).skip(1).findFirst().get();
		 System.out.println("Second Highest Paid Employee : "+secondHPaidWorker);
		 	//RightWay for Every Situation
		 Worker worker = empList.stream().sorted((e1, e2) -> Double.compare(e2.salary(), e1.salary())).filter(e -> e.salary() < highSalary).findFirst().get();
		 System.out.println("Employee With Second Highest Salary : "+worker);
		 System.out.println();
		 
		 //Que 3 : Find Employee who is most Senior based on Joining Date
		 	Date oldDateOfJoin = empList.stream().min((e1, e2) -> e1.dateOfJoin().compareTo(e2.dateOfJoin())).get().dateOfJoin();
		 	System.out.println("most Senoir Employees Are : ");
		 	empList.stream().filter(e -> e.dateOfJoin().equals(oldDateOfJoin)).forEach(System.out :: println);
		 	System.out.println();
			 
		 	
		 //Que 4 : Count Employee Based on Gender
		 			//By Using Filter and Count
		 	long maleCount = empList.stream().filter(e -> e.gender().startsWith("M")).count();
		 	System.out.println("Total Number Of Male Employees are : "+maleCount);
		 	long femaleCount = empList.stream().filter(e -> e.gender().startsWith("F")).count();
		 	System.out.println("Total Number Of Male Employees are : "+femaleCount);
		 			//Using Map and GroupBy Method Of Collectors Class
		 	Map<String, Long> collectGender = empList.stream().collect(Collectors.groupingBy(Worker :: gender, Collectors.counting()));
		 	System.out.println("Total Member by Gender :"+collectGender);
	}

}
