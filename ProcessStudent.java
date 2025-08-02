package com.am.streams;

import java.util.List;
import java.util.stream.Stream;

record Student(String studentName, Integer passingGrade)
{
	
}

public class ProcessStudent
{
	public static void main(String[] args)
	{
		Stream<Student> std = Stream.of(new Student("Karan", 93), new Student("Akshay", 90), new Student("Saurabh", 97));
	
		List<Student> sortedStudent = std.sorted((s1,s2) -> Integer.compare(s2.passingGrade(), s1.passingGrade())).toList();
		
		sortedStudent.forEach(System.out :: println);
	}
}
