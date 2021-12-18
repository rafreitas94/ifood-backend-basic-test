package com.ifood.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ifood.client.OpenWeatherClient;
import com.ifood.model.WeatherClient;
import com.ifood.model.response.WeatherClientResponse;
import feign.FeignException.FeignClientException;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(path = "/weather")
public class WeatherController {
    @Value("${weatherAppId}")
    private String weatherAppId;

    private final OpenWeatherClient openWeatherClient;

    public WeatherController(OpenWeatherClient openWeatherClient) {
        this.openWeatherClient = openWeatherClient;
    }

    @GetMapping
    @Cacheable("city")
    @CircuitBreaker(name="weatherService", fallbackMethod = "weatherFallback")
    public ResponseEntity<WeatherClientResponse> getWeather(@RequestParam("city") String city) {
        WeatherClient weather = openWeatherClient.getWeather(city, weatherAppId);
        return ResponseEntity.status(weather.getCod()).body(new WeatherClientResponse(weather));
    }

    public ResponseEntity<JsonNode> weatherFallback(FeignClientException e) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(e.contentUTF8());
        return ResponseEntity.status(e.status()).body(node);
    }

    public ResponseEntity<Map<String, Object>> weatherFallback(CallNotPermittedException e) {
        Map<String, Object> bodyMap = Map.of("message", e.getMessage());
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(bodyMap);
    }
}
