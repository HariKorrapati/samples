package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AssignmentApplicationTests {
	@Autowired
	GenericService service;

	@Test
	public void testFibonacci() throws Exception {
		// test fibonacci
		assertEquals(0, service.getFibonacci(0));
		assertEquals(1, service.getFibonacci(1));
		assertEquals(2, service.getFibonacci(3));
		assertEquals(13, service.getFibonacci(7));
		assertEquals(55, service.getFibonacci(10));
		assertEquals(233, service.getFibonacci(13));

	}

	@Test
	public void testReverseWords() throws Exception {
		// tests reverse sentence
		assertTrue("woH era uoy".equals(service.reverseSentence("How are you")));
		assertTrue(service.reverseSentence(null) == null);
	}

	@Test
	public void testTriangleType() throws Exception {
		// get triangle type
		assertTrue("Equilateral".equals(service.getTriangleType(1, 1, 1)));
		assertTrue("Isosceles".equals(service.getTriangleType(100, 100, 150)));
		assertTrue("Isosceles".equals(service.getTriangleType(10, 20, 20)));
		assertTrue("Isosceles".equals(service.getTriangleType(10, 20, 10)));
		assertTrue("Scalene".equals(service.getTriangleType(10, 20, 30)));
	}

	@Test
	public void testMakeOneArray() throws Exception {
		// merge arrays
		Map<String, long[]> arrayMap = new HashMap<>();
		arrayMap.put("Array1", new long[] { 1, 3, 2 });
		arrayMap.put("Array2", new long[] { 6, 5, 2 });
		arrayMap.put("Array3", new long[] { 7, 5, 3, 4, 8, 1 });
		Arrays.equals(new long[] { 1, 2, 3, 4, 5, 6, 7, 8 }, service.mergeArrays(arrayMap));
	}
}
