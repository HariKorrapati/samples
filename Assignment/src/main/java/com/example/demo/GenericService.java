package com.example.demo;

import java.util.Map;

public interface GenericService {
	/**
	 * Method to get the Fibonacci number at a given position.
	 * 
	 * @param position
	 * @return
	 */
	long getFibonacci(int position);

	/**
	 * Method to reverse the individual words of a sentence, separated by spaces.
	 * 
	 * @param sentence
	 * @return
	 */
	String reverseSentence(String sentence);

	/**
	 * Method to find the type of triangle based on the length of sides.
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	String getTriangleType(int a, int b, int c);

	/**
	 * Method to merge multiple arrays, remove duplicates and sort them.
	 * 
	 * @param arrays
	 * @return
	 */
	long[] mergeArrays(Map<String, long[]> arrays);
}
