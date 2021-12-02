package com.app.my.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.Properties;


@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan  // if you comment out ComponentScan the auto configuration is not picked considering no entry in spring.factories and class doesn't have @Configuration

/*
  Looks at /META-INF/spring.factories
  Each entry is a class that is declared with @Configuration
  Each @Configuration is conditional
 */
//@SpringBootApplication
public class ApplicationTomcat {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(ApplicationTomcat.class, args);
        Props props = ctx.getBean(Props.class);
        System.out.println(props.getTempPath());
        System.out.println(props.getProcessArch());
        System.out.println(props.getEnvironment());
        System.out.println(props.getTimeZone());
        System.out.println(props.getPort());

        //SpringApplication app = new SpringApplication(ApplicationTomcat.class);

        System.out.println("=======system properties==============");
        Properties properties = System.getProperties();
        // Java 8
        properties.forEach((k, v) -> System.out.println(k + ":" + v));
    }

}
