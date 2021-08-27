package com.app2;

import com.app2.Application;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

//@RunWith(SpringRunner.class) - Junit 4
@SpringBootApplication(scanBasePackageClasses= Application.class)
public class ApplicationTest2 {

	private static MockMvc mvc;
	
	@BeforeAll
	public static void setUp() {
		mvc = MockMvcBuilders.standaloneSetup(new Application()).build();
	}
	
	@Test
	public void testMe() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.TEXT_PLAIN))
		   .andExpect(MockMvcResultMatchers.status().isOk())
		   .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("App1")));
	}
}
