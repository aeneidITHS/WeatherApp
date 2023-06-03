package com.example.weatherapp.Service;

import com.example.weatherapp.Bussiness.Entities.METEntity;
import com.example.weatherapp.Bussiness.Entities.SHMIEntity;
import com.example.weatherapp.Bussiness.Entities.WeatherWebsiteEntity;
import org.springframework.stereotype.Service;

@Service
public class BestWeatherService {
    METEntity METEntity;
    SHMIEntity SMHIEntity;
    String bestWeatherSource;

    public BestWeatherService(METEntity METEntity, SHMIEntity SMHIEntity) {
        this.METEntity = METEntity;
        this.SMHIEntity = SMHIEntity;
    }


    public WeatherWebsiteEntity getBestWeather(int i){
        METEntity.setHour(i);
        METEntity.updateInfo();
        SMHIEntity.setHour(i);
        SMHIEntity.updateInfo();
        if(SMHIEntity.getTemperature()>METEntity.getTemperature()){
          bestWeatherSource = "SMHI";
          return SMHIEntity;
        }
        else {
            bestWeatherSource = "MET";
            return METEntity;
        }
    }

    public String getBestWeatherSource() {
        return bestWeatherSource;
    }
}
