package com.example.weatherapp.UI;

import com.example.weatherapp.Service.BestWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebsiteController {
    @Autowired
    BestWeatherService weatherService;

    public WebsiteController(BestWeatherService weatherService) {
        this.weatherService = weatherService;
    }
    @PostMapping("time")
    public String whatTimeDoYouWantYourWeather(Model m,@RequestParam int hour){
        m.addAttribute("bestWeather",weatherService.getBestWeather(hour));
        m.addAttribute("weatherSource",weatherService.getBestWeatherSource());
        return "weatherPage";
    }
}
