package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(AssignmentController.class)
@Import(WebSecurityConfig.class)
public class AssignmentControllerTest {
	@TestConfiguration
	static class AssignmentApplicationTestsContextConfiguration {
		@Bean
		public GenericService getGenericService() {
			return new GenericServiceImpl();
		}
	}

	@Autowired
	GenericService service;

	@Autowired
	MockMvc mvc;

	private MvcResult result;

	@Test
	public void testFibonacci() throws Exception {
		// test fibonacci
		result = mvc.perform(get("/api/Fibonacci?n=10")).andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_VALUE)).andReturn();

		assertEquals("55", result.getResponse().getContentAsString());
	}

	@Test
	public void testReverseWords() throws Exception {
		// tests reverse sentence
		result = mvc.perform(get("/api/ReverseWords?sentence=How are you")).andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		assertTrue("woH era uoy".equals(result.getResponse().getContentAsString()));
	}

	@Test
	public void testTriangleType() throws Exception {
		// get triangle type
		result = mvc.perform(get("/api/TriangleType?a=10&b=20&c=10")).andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		assertTrue("Isosceles".equals(result.getResponse().getContentAsString()));
	}

	@Test
	public void testMakeOneArray() throws Exception {
		Map<String, long[]> arrays = new HashMap<>();
		arrays.put("Array1", new long[] { 9, 8, 7, 6 });
		arrays.put("Array2", new long[] { 1, 3, 2, 4 });
		arrays.put("Array3", new long[] { 10, 5, 9, 1 });

		long[] expectedResult = new long[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		// make one array
		result = mvc
				.perform(post("/api/makeonearray").contentType(MediaType.APPLICATION_JSON)
						.content("{\"Array3\":[10,5,9,1],\"Array1\":[9,8,7,6],\"Array2\":[1,3,2,4]}"))
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_VALUE)).andReturn();

		assertTrue(new ObjectMapper().writeValueAsString(expectedResult)
				.equals(result.getResponse().getContentAsString()));
	}
}