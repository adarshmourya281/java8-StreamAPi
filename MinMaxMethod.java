package com.akshu.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MinMaxMethod {

	public static void main(String[] args)
	{
		List<Integer> list = Arrays.asList(5, 10, 16, 25, 20, 15,30);
		
		//Max method will take Comparator as parameter and return the last element fromthe Stream
		Integer max = list.stream().max((a,b) -> b.compareTo(a)).get();
		System.out.println("Smallest : "+max);
		
		//Min method will take Comparator as Argument and Return tye Frist Element in Stream
		Integer min = list.stream().min((a,b) -> b.compareTo(a)).get();
		System.out.println("Biggest "+min);
		
		//
		Integer m = list.stream().min((a,b) -> Integer.compare(b, a)).get();
		System.out.println(m);
		
		
	}

}
