package com.app.profiles.conditional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConditionalConfig {

	@Bean
	public MyConditionalMessage myMessage(@Value("${my.messageValue}") String messageValue) {
		MyConditionalMessage myMessage = new MyConditionalMessage();
		myMessage.setMessageValue(messageValue);
		return myMessage;
	}

}
