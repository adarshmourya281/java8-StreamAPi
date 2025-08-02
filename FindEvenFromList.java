package com.am.streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FindEvenFromList 
{

	public static void main(String[] args)
	{
		List<Integer> list = Arrays.asList(5,10,15,20,5,25,30,35);
		
		List<Integer> filteredList1 = list.stream().filter(i -> i%2==0 ).collect(Collectors.toList());
		
		//From java 16 
		List<Integer> filteredList2 = list.stream().filter(i -> i%2==0).toList();
		
		System.out.println(filteredList1 +"\n"+filteredList2);
		
		List<String> nameList =  Arrays.asList("Akshay","Arjun","Karam","Vikas","akash");
		
		List<String> nameAList = nameList.stream().filter(name -> name.startsWith("A")).toList();
		
		System.out.println(nameAList);
		
	}

}
