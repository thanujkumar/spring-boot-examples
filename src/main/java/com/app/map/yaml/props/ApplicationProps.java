package com.app.map.yaml.props;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
//https://www.baeldung.com/configuration-properties-in-spring-boot

@SpringBootApplication
//@EnableConfigurationProperties //To support @ConfigurationProperties
@ConfigurationPropertiesScan
public class ApplicationProps {
    public static void main(String[] args) {
       ConfigurableApplicationContext ctx = SpringApplication.run(ApplicationProps.class);
       MapYamlProps appProps = ctx.getBean(MapYamlProps.class);
        System.out.println(appProps.getProjectName());
    }
}
