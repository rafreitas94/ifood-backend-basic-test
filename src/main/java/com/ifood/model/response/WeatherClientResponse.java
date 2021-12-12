package com.ifood.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ifood.model.WeatherClient;

import java.util.List;
import java.util.stream.Collectors;

public class WeatherClientResponse {
    @JsonProperty(value = "weather")
    private final List<WeatherResponse> weatherResponses;
    private final Double temp;
    @JsonProperty(value = "feels_like")
    private final Double feelsLike;
    @JsonProperty(value = "temp_min")
    private final Double tempMin;
    @JsonProperty(value = "temp_max")
    private final Double tempMax;
    private final Double pressure;
    private final Double humidity;

    public WeatherClientResponse(WeatherClient weatherClient) {
        this.weatherResponses = weatherClient.getWeather().stream().map(WeatherResponse::new).collect(Collectors.toList());
        this.temp = weatherClient.getMain().getTemp();
        this.feelsLike = weatherClient.getMain().getFeelsLike();
        this.tempMin = weatherClient.getMain().getTempMin();
        this.tempMax = weatherClient.getMain().getTempMax();
        this.pressure = weatherClient.getMain().getPressure();
        this.humidity = weatherClient.getMain().getHumidity();
    }

    public List<WeatherResponse> getWeatherResponses() {
        return weatherResponses;
    }

    public Double getTemp() {
        return temp;
    }

    public Double getFeelsLike() {
        return feelsLike;
    }

    public Double getTempMin() {
        return tempMin;
    }

    public Double getTempMax() {
        return tempMax;
    }

    public Double getPressure() {
        return pressure;
    }

    public Double getHumidity() {
        return humidity;
    }
}
