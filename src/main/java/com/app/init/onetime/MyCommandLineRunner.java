package com.app.init.onetime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyCommandLineRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
	 System.out.println(">-------------CommandLineRunner----------------");
	 for (String s : args) {
		 System.out.println(s);
	 }
	 System.out.println("<-------------CommandLineRunner----------------");


	}

}
