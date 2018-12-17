package com.app.propconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableConfigurationProperties(value= {MyMessagesFromConfiguration.class})
public class ApplicationEnableProp {

	@Autowired
	private MyMessagesFromConfiguration message;

	
	@RequestMapping("/")
	public String welcome() {
		return "This is using @ConfigurationProperites and @EnableConfigurationProperties  "+ message.getMsg() +" and "+message.getName_print() +" and "+ message.getName().getTest();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ApplicationEnableProp.class, args);
	}
}
