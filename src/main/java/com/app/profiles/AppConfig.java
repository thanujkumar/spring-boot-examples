package com.app.profiles;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

// Label beans as belonging to different environments (like dev, prod etc)
// In case of spring boot, we can also use application.profile.properties file
@Configuration
public class AppConfig {

	@Bean
	@Profile("Prod")
	public MyMessage myMessage(@Value("${my.messageValue}") String messageValue) {
		MyMessage myMessage = new MyMessage();
		myMessage.setMessageValue(messageValue);
		return myMessage;
	}
	
	@Bean
	@Profile("Dev")
	public MyMessage myMessageDev() {
		MyMessage myMessage = new MyMessage();
		myMessage.setMessageValue("This is in Dev mode");
		return myMessage;
	}
}
