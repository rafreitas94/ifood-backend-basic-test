package com.ifood.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.TimeZone;

public class WeatherClientTest {

    public static WeatherClient instance() {
        return new WeatherClient(
                CoordTest.instance(),
                List.of(WeatherTest.instance()),
                "stations",
                MainTest.instance(),
                10000,
                WindTest.instance(),
                CloudsTest.instance(),
                1639836032L,
                SysTest.instance(),
                TimeZone.getTimeZone("GMT"),
                3449344L,
                "São Bernardo do Campo",
                200
        );
    }

    @Test
    void getWeatherClient() {
        WeatherClient weather = WeatherClientTest.instance();

        Assertions.assertNotNull(weather.getCoord());
        Assertions.assertNotNull(weather.getWeather());
        Assertions.assertEquals("stations", weather.getBase());
        Assertions.assertNotNull(weather.getMain());
        Assertions.assertEquals(10000, weather.getVisibility());
        Assertions.assertNotNull(weather.getWind());
        Assertions.assertNotNull(weather.getClouds());
        Assertions.assertEquals(1639836032L, weather.getDt());
        Assertions.assertNotNull(weather.getSys());
        Assertions.assertEquals(TimeZone.getTimeZone("GMT"), weather.getTimezone());
        Assertions.assertEquals(3449344L, weather.getId());
        Assertions.assertEquals("São Bernardo do Campo", weather.getName());
        Assertions.assertEquals(200, weather.getCod());
    }
}