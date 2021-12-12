package com.ifood.controllers;

import com.ifood.client.OpenWheaterClient;
import com.ifood.model.WeatherClient;
import com.ifood.model.response.WeatherClientResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/weather")
public class WeatherController {
    @Value("${weatherAppId}")
    private String weatherAppId;

    private final OpenWheaterClient openWheaterClient;

    public WeatherController(OpenWheaterClient openWheaterClient) {
        this.openWheaterClient = openWheaterClient;
    }

    @GetMapping
    public ResponseEntity<WeatherClientResponse> getWeather(@RequestParam("city") String city) {
        WeatherClient weather = openWheaterClient.getWeather(city, weatherAppId);
        return ResponseEntity.status(weather.getCod()).body(new WeatherClientResponse(weather));
    }
}
