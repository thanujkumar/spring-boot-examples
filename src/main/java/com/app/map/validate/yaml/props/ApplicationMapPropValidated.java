package com.app.map.validate.yaml.props;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ConfigurableApplicationContext;

//https://reflectoring.io/validate-spring-boot-configuration-parameters-at-startup/
//https://www.baeldung.com/spring-boot-bean-validation

@SpringBootApplication
@ConfigurationPropertiesScan
public class ApplicationMapPropValidated {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(ApplicationMapPropValidated.class);
        MyConfigurationProperties appProps = ctx.getBean(MyConfigurationProperties.class);
        System.out.println(appProps.getNumberText());
        System.out.println(appProps.getUser().getName());

        System.out.println(appProps.getPort());
        System.out.println(appProps.getProcessArch());
        System.out.println(appProps.getTimeZone());
    }
}
