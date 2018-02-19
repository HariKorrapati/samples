package com.example.demo;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Service;

@Service
public class GenericServiceImpl implements GenericService {

	@Override
	public long getFibonacci(int position) {
		long fibonacciNumber = 0;
		if (position == 0) {
			fibonacciNumber = 0;
		} else if (position == 1) {
			fibonacciNumber = 1;
		} else {
			long num1 = 0;
			long num2 = 1;
			for (int i = 1; i < position; i++) {
				fibonacciNumber = num1 + num2;
				num1 = num2;
				num2 = fibonacciNumber;
			}
		}

		return fibonacciNumber;
	}

	@Override
	public String reverseSentence(String sentence) {
		if (sentence == null) {
			return null;
		}

		StringBuilder reverseStr = new StringBuilder();
		for (String str : sentence.split(" ")) {
			reverseStr.append(new StringBuilder(str).reverse()).append(" ");
		}

		return reverseStr.toString().trim();
	}

	@Override
	public String getTriangleType(int a, int b, int c) {
		String triangleType;
		if (a == b && b == c) {
			triangleType = "Equilateral";
		} else if (a == b || a == c || b == c) {
			triangleType = "Isosceles";
		} else {
			triangleType = "Scalene";
		}
		return triangleType;
	}

	@Override
	public long[] mergeArrays(Map<String, long[]> arraysList) {
		Set<Long> list = new TreeSet<>();

		for (long[] array : arraysList.values()) {
			for (long n : array) {
				list.add(n);
			}
		}

		return list.stream().mapToLong(l -> l).toArray();
	}
}
