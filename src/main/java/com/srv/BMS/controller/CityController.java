package com.srv.BMS.controller;

import com.srv.BMS.model.City;
import com.srv.BMS.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {

    private CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping("/city")
    public City addCity(@RequestParam String name){
        return this.cityService.addCity(name);
    }
}
