package com.ifood.model;

import com.ifood.model.response.WeatherResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WeatherResponseTest {

    public static WeatherResponse instance() {
        return new WeatherResponse("Clouds", "broken clouds");
    }

    @Test
    void getWeatherResponseInstance() {
        WeatherResponse weatherResponse = WeatherResponseTest.instance();

        Assertions.assertEquals("Clouds", weatherResponse.getMain());
        Assertions.assertEquals("broken clouds", weatherResponse.getDescription());
    }
}