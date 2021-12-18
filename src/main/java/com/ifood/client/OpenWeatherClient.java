package com.ifood.client;

import com.ifood.model.WeatherClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "openweather", url = "${urlOpenWeather}")
public interface OpenWeatherClient {

    @GetMapping("data/2.5/weather?q={city}&appid={weatherAppId}")
    WeatherClient getWeather(@PathVariable("city") String city, @PathVariable("weatherAppId") String appId);
}
