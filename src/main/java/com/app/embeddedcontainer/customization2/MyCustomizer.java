package com.app.embeddedcontainer.customization2;

import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyCustomizer implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {

	@Bean
	public ConfigurableServletWebServerFactory factory() {
		//TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
		JettyServletWebServerFactory factory = new JettyServletWebServerFactory();
		return factory;
	}

	@Override
	public void customize(ConfigurableServletWebServerFactory factory) {
		factory.setPort(9102);
		factory.setContextPath("/two");
	}
}
