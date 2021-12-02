package com.app.my.starter;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
//In SpEL systemProperties and systemEnvironment are part of a Environment bean which provide information at runtime (late binding)
@Component
@Data
public class Props {

    @Autowired
    private Environment environment;

    @Value("#{systemEnvironment['TEMP']}") // all OS environment variables, example set command in windows or env on linux
    private  String tempPath;

    @Value("#{systemEnvironment['PROCESSOR_ARCHITECTURE']}")
    private String processArch;

    @Value("${server.port}") // See the syntax to read properties from application.yaml
    private String port;

   @Value("#{systemProperties['user.timezone']}") //This is JVM system properties and those passed as system arguments  using -D
   private String timeZone;
}
