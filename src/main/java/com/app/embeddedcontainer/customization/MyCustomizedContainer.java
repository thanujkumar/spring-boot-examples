package com.app.embeddedcontainer.customization;

import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.stereotype.Component;

/*
 * EmbeddedServletContainerCustomizer and ConfigurableEmbeddedServletContainer
 * not available from Spring Boot 2. The functionality is still available
 * through the interface WebServerFactoryCustomizer and the class
 * ConfigurableServletWebServerFactory.
 *
 *https://www.baeldung.com/embeddedservletcontainercustomizer-configurableembeddedservletcontainer-spring-boot	
 */
@Component
public class MyCustomizedContainer implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory>/*or any implementation like jetty, tomcat, undertow*/ {

	@Override
	public void customize(ConfigurableServletWebServerFactory factory) {
		factory.setPort(9001);
		factory.setContextPath("/one");
	}

	

}
