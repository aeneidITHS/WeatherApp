package com.example.weatherapp.RestController;

import com.example.weatherapp.Bussiness.Entities.WeatherWebsiteEntity;
import com.example.weatherapp.Service.BestWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestWebsiteController {
    @Autowired
    BestWeatherService bestWeatherService;

    public RestWebsiteController(BestWeatherService bestWeatherService) {
        this.bestWeatherService = bestWeatherService;
    }

    @GetMapping("/rest/weather/{hour}")
    public WeatherWebsiteEntity getBestWeather(@PathVariable int hour ){
        System.out.println("reached here");
       return bestWeatherService.getBestWeather(hour);
    }
}
