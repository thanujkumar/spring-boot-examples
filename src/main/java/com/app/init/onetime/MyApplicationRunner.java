package com.app.init.onetime;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationRunner implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		 System.out.println(">-------------ApplicationRunner----------------");
		 for (String s : args.getOptionNames()) {
			 System.out.println(s);
		 }
		 System.out.println("<-------------ApplicationRunner----------------");

	}

}
