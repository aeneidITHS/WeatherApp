package com.example.weatherapp.Bussiness.Entities;

import com.example.weatherapp.Clients.METClient;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class METEntity extends WeatherWebsiteEntity {
    public METClient metClient;
    public METEntity(){
        metClient = new METClient();
        dataSource = "MET";
    }
    public void updateInfo(){
     temperature = getTemperatureByTime(hour);
     humidity = getHumidityByTime(hour);
     currentTime = getMETCurrentTime();
    }

    public Integer getTemperatureByTime(int hour){
        return metClient.weatherServiceMET.getProperties().getTimeseries().get(checkIfTimeIsCorrect()+hour).getData().getInstant().getDetails().getAirTemperature().intValue();
    }
    public Integer getHumidityByTime(int hour){
        return metClient.weatherServiceMET.getProperties().getTimeseries().get(checkIfTimeIsCorrect()+hour).getData().getInstant().getDetails().getRelativeHumidity().intValue();
    }

    public LocalDateTime getMETCurrentTime(){
        return LocalDateTime.parse(metClient.weatherServiceMET.getProperties().getTimeseries().get(checkIfTimeIsCorrect()+hour).getTime(),DateTimeFormatter.ISO_DATE_TIME);
    }

    public Integer checkIfTimeIsCorrect(){
        boolean isCorrect = true;
        int i = 0;
        LocalDateTime localDateTime = LocalDateTime.parse(metClient.weatherServiceMET.getProperties().getTimeseries().get(0).getTime(), DateTimeFormatter.ISO_DATE_TIME);
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
