package com.example.weatherapp.Clients;

import com.example.weatherapp.Bussiness.WeatherSMHI.WeatherServiceSHMI;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class SMHIClient {

    public  WebClient client = WebClient.create();
    public WeatherServiceSHMI weatherServiceSHMI;
    public SMHIClient() {
        weatherServiceSHMI =getWeatherDataSMHI();
    }

    public WeatherServiceSHMI getWeatherDataSMHI(){
        Mono<WeatherServiceSHMI> mono = client
                .get()
                .uri("https://opendata-download-metfcst.smhi.se/api/category/pmp3g/version/2/geotype/point/lon/18.0300/lat/59.3110/data.json")
                .retrieve()
                .bodyToMono(WeatherServiceSHMI.class);
        return mono.block();
    }

}
