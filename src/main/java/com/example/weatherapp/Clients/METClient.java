package com.example.weatherapp.Clients;

import com.example.weatherapp.Bussiness.WeatherMET.WeatherServiceMET;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
@Service
public class METClient {
    public WebClient client;

    public WeatherServiceMET weatherServiceMET;

    public METClient() {
    weatherServiceMET = getWeatherServiceMET();
    }


    public WeatherServiceMET getWeatherServiceMET() {
        Mono<WeatherServiceMET> mono = client
                .get()
                .uri("https://api.met.no/weatherapi/locationforecast/2.0/compact?lat=59.3110&lon=18.0300")
                .retrieve()
                .bodyToMono(WeatherServiceMET.class);
        return mono.block();
    }
}
