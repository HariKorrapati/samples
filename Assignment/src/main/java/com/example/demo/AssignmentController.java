package com.example.demo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AssignmentController {
	@Autowired
	GenericService service;

	/**
	 * API to get the Fibonacci number at a given position.
	 * 
	 * @param n
	 * @return
	 */
	@GetMapping(value = "/api/Fibonacci", produces = { MediaType.APPLICATION_JSON_VALUE })
	public long getFibonacciNumber(@RequestParam int n) {
		return service.getFibonacci(n);
	}

	/**
	 * API to reverse the individual words of a sentence, separated by spaces.
	 * 
	 * @param sentence
	 * @return
	 */
	@GetMapping(value = "/api/ReverseWords", produces = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody ResponseEntity<String> reverseSentence(@RequestParam String sentence) {
		return ResponseEntity.ok().body(service.reverseSentence(sentence));
	}

	/**
	 * API to find the type of triangle based on the length of sides.
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	@GetMapping(value = "/api/TriangleType", produces = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody ResponseEntity<String> getTriangleType(@RequestParam int a, @RequestParam int b,
			@RequestParam int c) {
		return ResponseEntity.ok().body(service.getTriangleType(a, b, c));
	}

	/**
	 * API to merge multiple arrays, remove duplicates and sort them.
	 * 
	 * @param arrays
	 * @return
	 */
	@PostMapping(value = "/api/makeonearray", produces = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody long[] mergeArrays(@RequestBody Map<String, long[]> arrays) {
		return service.mergeArrays(arrays);
	}
}