package com.app.lucky.number;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyMessage {

	 //https://www.logicbig.com/tutorials/spring-framework/spring-boot/random-properties.html
	
	@Value("${my.messageValue}")
	private int messageValue;
	
	@Value("${find.randomObj}")
	private Object random;

	public int getMessageValue() {
		return messageValue;
	}

	public void setMessageValue(int messageValue) {
		this.messageValue = messageValue;
	}

	public Object getRandom() {
		return random;
	}

	public void setRandom(Object random) {
		this.random = random;
	}
	
	
}
