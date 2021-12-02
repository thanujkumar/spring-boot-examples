package com.app.my.starter;

import org.apache.catalina.startup.Tomcat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/*
  Looks at /META-INF/spring.factories
  Each entry is a class that is declared with @Configuration
  Each @Configuration is conditional
 */

@Configuration //Comment this to be picked only based on the spring.factories
@ConditionalOnClass(Tomcat.class)
@ConditionalOnProperty(name = "log-tomcat-version", matchIfMissing = true)
public class LogTomcatVersionAutoConfiguration {
    private static final Logger log = LoggerFactory.getLogger(LogTomcatVersionAutoConfiguration.class);

    @PostConstruct
    public void logTomcatVersion() {
        log.info("\n\n\n Tomcat v" + Tomcat.class.getPackage().getImplementationVersion() + "\n\n");
    }
}
