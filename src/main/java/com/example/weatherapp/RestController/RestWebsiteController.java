package com.example.weatherapp.RestController;

import com.example.weatherapp.Bussiness.Entities.WeatherWebsiteEntity;
import com.example.weatherapp.Service.BestWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestWebsiteController {
    @Autowired
    BestWeatherService bestWeatherService;
    @GetMapping("/rest/weather/{hour}")
    public WeatherWebsiteEntity getBestWeather(@PathVariable int hour ){
        return bestWeatherService.getBestWeather(hour);
    }
    @GetMapping("/rest/weather/{hour}")
    public String getBestWeatherSource(@PathVariable int hour){
        return bestWeatherService.getBestWeatherSource();
    }

}
