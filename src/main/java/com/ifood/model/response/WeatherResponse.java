package com.ifood.model.response;

import com.ifood.model.Weather;

public class WeatherResponse {
    private final String main;
    private final String description;

    public WeatherResponse(String main, String description) {
        this.main = main;
        this.description = description;
    }

    public WeatherResponse(Weather weather) {
        this.main = weather.getMain();
        this.description = weather.getDescription();
    }

    public String getMain() {
        return main;
    }

    public String getDescription() {
        return description;
    }
}
