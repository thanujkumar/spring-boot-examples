package com.app.map.yaml.props;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@Data
@ConfigurationProperties(prefix = "tk")
public class MapYamlProps {

    private String projectName;

}
