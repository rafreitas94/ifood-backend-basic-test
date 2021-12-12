package com.ifood.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Main {
    private final Double temp;
    @JsonProperty(value = "feels_like")
    private final Double feelsLike;
    @JsonProperty(value = "temp_min")
    private final Double tempMin;
    @JsonProperty(value = "temp_max")
    private final Double tempMax;
    private final Double pressure;
    private final Double humidity;

    public Main(Double temp, Double feelsLike, Double tempMin, Double tempMax, Double pressure, Double humidity) {
        this.temp = temp;
        this.feelsLike = feelsLike;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
        this.pressure = pressure;
        this.humidity = humidity;
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
