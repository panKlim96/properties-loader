package com.teachbase.controller;


import com.teachbase.config.CarsProperties;
import com.teachbase.config.Unknown;
import com.teachbase.config.dto.CarsPropertiesDto;
import com.teachbase.service.PropertySourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/propertiesLoader")
public class PropLoaderController {

    @Autowired
    private CarsProperties carsProperties;

    @Autowired
    private PropertySourceService propertySourceService;

    @GetMapping("/getCarsProperties")
    public ResponseEntity<String> getCarsProperties() {
        return new ResponseEntity<>(carsProperties.getCarsProperties(), HttpStatus.OK);
    }

    @GetMapping("/setCarsProperties")
    public ResponseEntity<String> setCarsProperties(@RequestBody CarsPropertiesDto carsPropertiesDto) {
        return new ResponseEntity<>(propertySourceService.updateCarProperties(carsPropertiesDto), HttpStatus.OK);
    }
}
