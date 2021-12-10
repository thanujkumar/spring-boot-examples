package com.app.batch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;

//https://github.com/spring-projects/spring-batch/tree/main/spring-batch-core/src/main/resources/org/springframework/batch/core

@SpringBootApplication
public class ApplicationBatch {
    static {
        System.setProperty("spring.profiles.active", "batch"); //appkcation-batch.xml
    }

    public static void main(String[] args) throws InterruptedException {
       SpringApplication application = new SpringApplication();
       application.run(ApplicationBatch.class);
    }
}
