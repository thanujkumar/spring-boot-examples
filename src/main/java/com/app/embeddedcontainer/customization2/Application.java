package com.app.embeddedcontainer.customization2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * The @SpringBootApplication annotation (or, more precisely the
 * inferred @ComponentScan annotation) by default only scans the classpath next
 * to and below the annotated class.
 */

@SpringBootApplication()
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


}
