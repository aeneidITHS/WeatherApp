package com.example.weatherapp.Bussiness.Entities;

import com.example.weatherapp.Clients.SMHIClient;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
@Component
public class SHMIEntity extends WeatherWebsiteTemplate{
    SMHIClient smhiClient;
    public SHMIEntity() {
        smhiClient = new SMHIClient();
        dataSource = "SMHI";
    }

public boolean checkIfTimeIsCorrect(){

}


}
