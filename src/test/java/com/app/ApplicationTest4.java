package com.app;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;


@AutoConfigureWebTestClient
@SpringBootTest(classes= {Application.class}, webEnvironment = WebEnvironment.RANDOM_PORT)
public class ApplicationTest4 {

	@Autowired
    private TestRestTemplate template;

	
	@Test
	public void testMe() throws Exception {
		System.out.println(template.getForEntity("/", String.class).getBody());
		assertTrue(template.getForEntity("/", String.class).getBody().contentEquals("Hello.."));
	}
	
}
