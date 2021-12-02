package com.app.lucky.number;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner.Mode;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//As keys are present in both application.yml and application.properties with different data types you will get error
//This is to show that first application.yml is loaded and last application.properties

@SpringBootApplication
@RestController
public class Application3RandomNum {

	@Autowired
	private MyMessage myMessage;


	@RequestMapping("/")
	public String welcome() {
		return "Welcome your lucky number is : " + myMessage.getMessageValue();
	}

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Application3RandomNum.class);
		app.setBannerMode(Mode.OFF);
		app.setLogStartupInfo(false);
		ConfigurableApplicationContext context = app.run(args);
        System.out.println(context);
		MyMessage myMessage = context.getBean(MyMessage.class);
		System.out.println("======================" + myMessage.getMessageValue());
		System.out.println("======================" + myMessage.getRandom());
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Let's inspect the beans provided by Spring Boot: "+ myMessage.getRandom() );

			Arrays.asList(ctx.getBeanDefinitionNames()).stream().sorted().forEach(System.out::println);
		};
	}

}
