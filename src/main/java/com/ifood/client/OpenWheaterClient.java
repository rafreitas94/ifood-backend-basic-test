package com.ifood.client;

import com.ifood.model.WeatherClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "openwheater", url = "${urlOpenWeather}")
public interface OpenWheaterClient {

    @GetMapping("data/2.5/weather?q={city}&appid={weatherAppId}")
    WeatherClient getWeather(@PathVariable("city") String city, @PathVariable("weatherAppId") String appId);
}
