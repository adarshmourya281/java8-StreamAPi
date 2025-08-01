package com.akshu.streams;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class LongestStringExample {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");

        Optional<String> longestString = strings.stream()
                                                .max(Comparator.comparingInt(String::length));

        longestString.ifPresent(longest -> System.out.println("Longest string: " + longest));
    }
}