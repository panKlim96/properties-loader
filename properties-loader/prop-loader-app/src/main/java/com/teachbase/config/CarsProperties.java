package com.teachbase.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.origin.OriginTrackedValue;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;

import java.math.BigDecimal;
import java.util.Map;

import static java.util.Objects.nonNull;

@Data
@Slf4j
@Configuration
public class CarsProperties {
    private String model;
    private BigDecimal cost;
    private Integer number;
    private ConfigurableEnvironment environment;

    public CarsProperties(ConfigurableEnvironment environment) {
        this.environment = environment;
        Map<String, ?> map = (Map<String, ?>) environment.getPropertySources().get("cars-properties").getSource();
        this.model = (String) ((OriginTrackedValue) map.get("config.carsProperties.model")).getValue();
        this.cost = BigDecimal.valueOf((Double) ((OriginTrackedValue) map.get("config.carsProperties.cost")).getValue());
        this.number = (Integer) ((OriginTrackedValue) map.get("config.carsProperties.number")).getValue();
    }

    public String getCarsProperties() {
        StringBuilder result = new StringBuilder();
        Map<String, Object> map = (Map<String, Object>) environment.getPropertySources().get("cars-properties").getSource();

        result.append("MODEL:" + map.get("config.carsProperties.model") + "\n");
        result.append("COST:" + map.get("config.carsProperties.cost") + "\n");
        result.append("NUMBER:" + map.get("config.carsProperties.number") + "\n");

        return result.toString();
    }
}
