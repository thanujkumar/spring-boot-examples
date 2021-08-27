package com.app.init.onetime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationInitRunner {
	//first application.yml will be loaded later
	//application.properties will be loaded, so any values are overridden

	public static void main(String[] args) {
		args = new String[]{"a", "b", "c"};

		SpringApplication.run(ApplicationInitRunner.class, args);
	}
}
