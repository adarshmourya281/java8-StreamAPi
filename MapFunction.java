package com.akshu.streams;

import java.util.Arrays;
import java.util.List;

public class MapFunction
{
	public static void main(String[] args) 
	{
		List<Integer> list = Arrays.asList(5, 10, 16, 25, 20, 15,30);
		
		// Map method of Stream Interface takes Function Interface as parameter and rerturn the data as same data type of Object passed
		// it is used to perform operation on provided parameter data
		//in the following program using map we are performing operation as making element as double 
		
		 List<Integer> list2 = list.stream().map(i -> i*i).toList();
		System.out.println(list2);
		
		List<Integer> passed = list.stream().filter(i -> i > 16).toList();
		
		System.out.println("Passed : "+passed);
		
		List<Integer> grasePassed = list.stream().filter(i -> i < 17).map(i -> i+2).filter(i -> i > 16).toList();
		
		System.out.println("Passed by Grase : "+grasePassed);
		
		
		//Count method return count the number of Elements or objects present inside the Stream
		//The Follwing count function return the number of Students Passed without grase marks
		
		long countPassed = list.stream().filter(i -> i > 16).count();
		System.out.println("Passed Without grase : "+countPassed);
		
		System.out.println("Passed with Grase: "+grasePassed.stream().count());
		
	}
}
