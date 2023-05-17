package com.example.weatherapp.UI;

import com.example.weatherapp.Clients.SMHIClient;
import org.springframework.boot.CommandLineRunner;
@org.springframework.stereotype.Controller
public class Controller implements CommandLineRunner {
    SMHIClient SMHIClient = new SMHIClient();
    @Override
    public void run(String... args) throws Exception {
        SMHIClient.findSpeficParametersAndTime(1);
    }
}
