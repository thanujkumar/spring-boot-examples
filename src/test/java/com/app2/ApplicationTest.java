package com.app2;

import com.app2.Application;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;



@AutoConfigureMockMvc
//@SpringBootTest(classes= {Application.class}, webEnvironment = WebEnvironment.RANDOM_PORT)
@SpringBootTest(classes= {Application.class}, webEnvironment = WebEnvironment.MOCK)
public class ApplicationTest {

	@Autowired
	MockMvc mvc;
	
	@Test
	public void testMe() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.TEXT_PLAIN))
		   .andExpect(MockMvcResultMatchers.status().isOk())
		   .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("Hello")));
	}
	
}
