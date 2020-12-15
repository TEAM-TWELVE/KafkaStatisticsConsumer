package com.example.demo.Controller;

import com.example.demo.Model.TopCity;
import com.example.demo.Service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;


@RestController
public class CityController {
    @Autowired
    CityService cityService;
    @GetMapping("")
    public Collection<TopCity> fetchMoveSearchedCity(){
        return cityService.fetchCityStatistics();
    }
}
