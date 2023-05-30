package com.example.weatherapp.Bussiness.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDateTime;

abstract public class WeatherWebsiteEntity {
    public Integer temperature;
    public Integer humidity;
    public LocalDateTime currentTime;
    public String dataSource;

    @JsonIgnore
    int hour;


    public WeatherWebsiteEntity(Integer temperature, Integer humidity, LocalDateTime currentTime) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.currentTime = currentTime;
    }

    public WeatherWebsiteEntity() {
    }


    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public LocalDateTime getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(LocalDateTime currentTime) {
        this.currentTime = currentTime;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }
    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }


}
