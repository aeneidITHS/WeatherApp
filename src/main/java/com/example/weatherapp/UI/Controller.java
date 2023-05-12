package com.example.weatherapp.UI;

import com.example.weatherapp.Bussiness.WeatherSMHI.WeatherDAO;
import org.springframework.boot.CommandLineRunner;
@org.springframework.stereotype.Controller
public class Controller implements CommandLineRunner {
    WeatherDAO weatherDAO;
    @Override
    public void run(String... args) throws Exception {
        weatherDAO.findSpeficParametersAndTime(1);
    }
}
