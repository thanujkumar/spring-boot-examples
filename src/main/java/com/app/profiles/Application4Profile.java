package com.app.profiles;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * Run with application argument --spring.profiles.active=Prod
 * or in application properties as spring.profiles.active=Prod
 */
@SpringBootApplication
@RestController
public class Application4Profile {

	   //Loads based on profile MyMessage object configured in AppConfig
	   //Also based on profile application-Dev.properties is loaded
       static {
    	   System.setProperty("spring.profiles.active", "Prod");
       }
	
		@Autowired
		private MyMessage myMessage;


		@RequestMapping("/")
		public String welcomeProfileMsg() {
			return "Welcome your lucky number is : " + myMessage.getMessageValue();
		}

		public static void main(String[] args) {
			SpringApplication app = new SpringApplication(Application4Profile.class);
			app.setBannerMode(Mode.OFF);
			app.setLogStartupInfo(false);
			ConfigurableApplicationContext context = app.run(args);
	        System.out.println(context);
			Arrays.asList(context.getBeanDefinitionNames()).stream().sorted().forEach(System.out::println);
			

		}

}
