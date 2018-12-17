package com.app.propconfig;

import org.springframework.boot.context.properties.ConfigurationProperties;

/*
 * Using @ConfigurationProperties
 */
@ConfigurationProperties(prefix="test")
public class MyMessagesFromConfiguration {
	
	private String msg;
	
	private String name_print;
	
	private final Name name = new Name();

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	

	public String getName_print() {
		return name_print;
	}

	public void setName_print(String name_print) {
		this.name_print = name_print;
	}

	
	public Name getName() {
		return name;
	}


	public static class Name {
		
		private String test;

		public String getTest() {
			return test;
		}

		public void setTest(String test) {
			this.test = test;
		}
	}
	
}
