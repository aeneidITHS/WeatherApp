package com.example.weatherapp.Bussiness.Entities;

import com.example.weatherapp.Bussiness.WeatherSMHI.Parameter;
import com.example.weatherapp.Clients.SMHIClient;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class SHMIEntity extends WeatherWebsiteEntity {
    SMHIClient smhiClient;
    public SHMIEntity() {
        smhiClient = new SMHIClient();
        dataSource = "SMHI";
    }
    public void updateInfo(){
        temperature=getTemperatureByTime(hour);
        humidity = getHumidityByTime(hour);
        currentTime = getTimeBySMHI(hour);
    }
    public LocalDateTime getTimeBySMHI(int hour){
        return LocalDateTime.parse(smhiClient.weatherServiceSHMI.getTimeSeries().get(checkIfTimeIsCorrect()+hour).getValidTime(),DateTimeFormatter.ISO_DATE_TIME);
    }
    public Integer getTemperatureByTime(int hour){
        int temperature = 0;
        for (Parameter p: smhiClient.weatherServiceSHMI.getTimeSeries().get(checkIfTimeIsCorrect()+hour).getParameters()){
            if (p.getName().equals("t")){
                temperature=p.getValues().get(0);
            }
        }
        return temperature;
    }
    public Integer getHumidityByTime(int hour){
        int humidity = 0;
        for (Parameter p: smhiClient.weatherServiceSHMI.getTimeSeries().get(checkIfTimeIsCorrect()+hour).getParameters()) {
            if (p.getName().equals("h")){
                humidity = p.getValues().get(0);
            }
        }
        return humidity;
    }

public Integer checkIfTimeIsCorrect(){
    boolean isCorrect = true;
    int i = 0;
    LocalDateTime localDateTime = LocalDateTime.parse(smhiClient.weatherServiceSHMI.getTimeSeries().get(0).getValidTime(), DateTimeFormatter.ISO_DATE_TIME);
    while (isCorrect){
        if (localDateTime.getHour() + i !=LocalDateTime.now().getHour()){
            i++;
        }
        else {
            isCorrect = false;
        }
    }
    return i;
}


}
