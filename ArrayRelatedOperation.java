package com.am.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ArrayRelatedOperation 
{

	public static void main(String[] args) 
	{
		List<Integer> list = Arrays.asList(5, 10, 16, 25, 20, 15,30);
		
		//We can convert an List Directly into array Using toArray() method
		//Using this if we pass Method Referance into Patrameter then we can Get the Any datatype Array
		Integer[] array = list.stream().toArray(Integer[] :: new);
		//Because toString method is not Overriden in Arrays class so to print use for loop
		
		for(Integer x : array)
		{
			System.out.print(x + " ");
		}
		System.out.println();
		
		
		//How to convert  Array into Stream
		 Arrays.stream(array).forEach(System.out :: println);
		 
		Stream.of(9,88,77,"AAA","c" ,'D').map(i -> i+"s").forEach(System.out :: println);
		 
		
	}

}
