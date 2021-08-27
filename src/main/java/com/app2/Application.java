package com.app2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@Import(MyConfiguration.class) // or @ComponentScan(package)
//@SpringBootApplication is equal to @EnableAutoConfiguration + @SpringBootConfiguration + @ComponentScan
public class Application {

	@Value("${name}")
	String name;
	
	@Autowired
	String message;
	
	@RequestMapping("/")
	public String home() {
		System.out.println(Thread.currentThread());
		return "App1-"+message +"-"+name;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
