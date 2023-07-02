package com.teachbase.service;

import com.teachbase.config.dto.CarsPropertiesDto;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.env.OriginTrackedMapPropertySource;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.nonNull;

@RequiredArgsConstructor
@Service
public class PropertySourceService {

    private final ConfigurableEnvironment environment;

    public String updateCarProperties(CarsPropertiesDto carsPropertiesDto) {
        StringBuilder result = new StringBuilder();
        MutablePropertySources propertySources = environment.getPropertySources();
        Map<String, Object> map = new HashMap<>((Map<String, Object>) environment.getPropertySources().get("cars-properties").getSource());
        if (nonNull(carsPropertiesDto.getModel())){
          result.append("OLD MODEL:" + map.get("config.carsProperties.model") +"\n");
          map.put("config.carsProperties.model", carsPropertiesDto.getModel());
          result.append("NEW MODEL:" + map.get("config.carsProperties.model") +"\n" + "\n") ;
        }
        if (nonNull(carsPropertiesDto.getCost())){
            result.append("OLD COST:" + map.get("config.carsProperties.cost") + "\n");
            map.put("config.carsProperties.cost", carsPropertiesDto.getCost());
            result.append("NEW COST:" + map.get("config.carsProperties.cost") + "\n" + "\n") ;
        }
        if (nonNull(carsPropertiesDto.getNumber())){
            result.append("OLD NUMBER:" + map.get("config.carsProperties.number") + "\n");
            map.put("config.carsProperties.number", carsPropertiesDto.getNumber());
            result.append("NEW NUMBER:" + map.get("config.carsProperties.number") + "\n" + "\n") ;
        }
        propertySources.replace("cars-properties", new OriginTrackedMapPropertySource("cars-properties",
                Collections.unmodifiableMap(map), true));

        return result.toString();
    }
}
