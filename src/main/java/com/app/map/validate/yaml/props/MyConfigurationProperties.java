package com.app.map.validate.yaml.props;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.*;

@Component
@Data
@ConfigurationProperties(prefix = "tk2")
@Validated
public class MyConfigurationProperties {


    @NotNull
    @Pattern(regexp = "[\\d]{6}") // only allow 6 numbers as text
    private String numberText;

    @Valid
    @NotNull
    private User user;

//    public void setUser(@Valid @NotNull User user) {
//         this.user = user;
//    }
//
//    public User getUser() {
//        return user;
//    }


    @Value("#{systemEnvironment['TEMP']}") // all OS environment variables, example set command in windows or env on linux
    private  String tempPath;

    @Value("#{systemEnvironment['PROCESSOR_ARCHITECTURE']}")
    private String processArch;

    @Value("${server.port}") // See the syntax to read properties from application.yaml
    private String port;

    @Value("#{systemProperties['user.timezone']}") //This is JVM system properties and those passed as system arguments  using -D
    private String timeZone;
}

@Data
class User {

    @NotNull
    @Size(min = 3, max = 5)
    private String name;
}