package com.ifood.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WeatherTest {

    public static Weather instance() {
        return new Weather(
                803L,
                "Clouds",
                "broken clouds",
                "04d"
        );
    }

    @Test
    void getWeatherInstance() {
        Weather weather = WeatherTest.instance();

        Assertions.assertEquals(803L, weather.getId());
        Assertions.assertEquals("Clouds", weather.getMain());
        Assertions.assertEquals("broken clouds", weather.getDescription());
        Assertions.assertEquals("04d", weather.getIcon());
    }
}