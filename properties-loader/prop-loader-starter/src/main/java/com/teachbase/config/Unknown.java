package com.teachbase.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.origin.OriginTrackedValue;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;

import java.math.BigDecimal;
import java.util.Map;

@Data
@Slf4j
@Configuration
public class Unknown {
        private String model;
        private BigDecimal cost;
        private Integer number;

    public Unknown(ConfigurableEnvironment environment) {
      Map<String, ?> map = (Map<String, ?>) environment.getPropertySources().get("cars-properties").getSource();
      this.model = (String) ((OriginTrackedValue) map.get("config.carsProperties.model")).getValue();
      this.cost = BigDecimal.valueOf((Double) ((OriginTrackedValue) map.get("config.carsProperties.cost")).getValue());
      this.number = (Integer) ((OriginTrackedValue) map.get("config.carsProperties.number")).getValue();
    }
}
