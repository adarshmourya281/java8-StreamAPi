package com.am.streams;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class FibonacciStream 
{
	public static void main(String[] args) 
	{
		System.out.print("How Many tearms you want in Fibonacci series  : ");
		
		var sc = new Scanner(System.in);
		
		int limit  = sc.nextInt();
		
		
		
		int t1 = 0;
		int t2 = 1;
		int t3;
		
		System.out.println(t1);
		System.out.println(t2);
		
		for(int i = 3 ; i <= limit ; i++ )
		{
			t3 = t1 + t2;
			System.out.println(t3);
			t1= t2;
			t2 = t3;
		}
		
		System.out.println("\nBy using Stream ...\n----------------------");
		
        Stream.iterate(new long[]{0, 1}, t -> new long[]{t[1], t[0] + t[1]}) 
        .map(t -> t[0]) 
        .limit(limit)
        .forEach(System.out::println); 
        
                
		System.out.println("\nBy using Stream ...\n----------------------");
		
		System.out.println("Array Size : ");
		int size = sc.nextInt();
		
        int[] arr = new int[size];
        
        System.out.println("Enter "+size+"Elemnts");
        for(int i =0 ; i <  size ; i++)
        {
        	System.out.println("Enter Element no "+i);
        	arr[i]= sc.nextInt();
        }

		Stream.iterate(arr , t -> 
		{
			int len = t.length;
			int[] n  = new int[--len];
			
			for(int i = 0 ; i < len ;i++)
			{
				n[i] = t[i]+t[i+1] ;
			}
			return n;
		}).map(t -> Arrays.toString(t)).limit(size).forEach(System.out ::println);
		sc.close();
		}
        
	
	}
