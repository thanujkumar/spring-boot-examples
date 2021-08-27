package com.app.profiles.conditional;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * Run with application argument --spring.profiles.active=dev where application-dev.properties is loaded
 *
 */
@SpringBootApplication
@RestController
public class ApplicationConditionalProfile {


		@Autowired
		private MyConditionalMessage myConditionalMessage;


		@RequestMapping("/cp")
		public String welcomeConditionalProfile() {
			return "Welcome your lucky number is : " + myConditionalMessage.getMessageValue();
		}

		public static void main(String[] args) {
			SpringApplication app = new SpringApplication(ApplicationConditionalProfile.class);
			app.setBannerMode(Mode.OFF);
			app.setLogStartupInfo(false);
			ConfigurableApplicationContext context = app.run(args);
	        System.out.println(context);
			Arrays.asList(context.getBeanDefinitionNames()).stream().sorted().forEach(System.out::println);
			

		}

}
