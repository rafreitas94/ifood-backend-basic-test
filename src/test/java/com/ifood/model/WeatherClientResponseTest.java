package com.ifood.model;

import com.ifood.model.response.WeatherClientResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WeatherClientResponseTest {

    public static WeatherClientResponse instance() {
        return new WeatherClientResponse(WeatherClientTest.instance());
    }

    @Test
    void getWeatherClientResponse() {
        WeatherClientResponse weatherClientResponse = WeatherClientResponseTest.instance();

        Assertions.assertEquals("Clouds", weatherClientResponse.getWeatherResponses().get(0).getMain());
        Assertions.assertEquals("broken clouds", weatherClientResponse.getWeatherResponses().get(0).getDescription());
        Assertions.assertEquals(295.38, weatherClientResponse.getTemp());
        Assertions.assertEquals(1016.0, weatherClientResponse.getFeelsLike());
        Assertions.assertEquals(76.0, weatherClientResponse.getTempMin());
        Assertions.assertEquals(295.64, weatherClientResponse.getTempMax());
        Assertions.assertEquals(295.38, weatherClientResponse.getPressure());
        Assertions.assertEquals(297.05, weatherClientResponse.getHumidity());
    }
}