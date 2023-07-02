package com.teachbase.config.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class CarsPropertiesDto {
    private String model;
    private BigDecimal cost;
    private Integer number;
}
