package com.teachbase.postProcessor;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;

public class PropertiesLoaderEnvironmentPostProcessor implements EnvironmentPostProcessor {

    YamlPropertySourceLoader ymlLoader = new YamlPropertySourceLoader();


    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        environment.getPropertySources();
        Resource path = new ClassPathResource("/cars-properties.yml");
        PropertySource<?> propertySource = loadYml(path);
        environment.getPropertySources().addLast(propertySource);
    }

    private PropertySource<?> loadYml(Resource path) {
        try {
           return this.ymlLoader.load("cars-properties", path).get(0);
        } catch (IOException e) {
            throw new IllegalStateException(
                    "Failed to load custom resources!" + path, e
            );
        }
    }

}
