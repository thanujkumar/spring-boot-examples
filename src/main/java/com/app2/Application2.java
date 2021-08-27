package com.app2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Application2 {

	@Value("${name}")
	String name;
	
	@Autowired
	String message;
	
	@RequestMapping("/app2")
	public String home() {
		System.out.println(Thread.currentThread());
		return "App2-"+message +"-"+name;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application2.class, args);
	}
}
