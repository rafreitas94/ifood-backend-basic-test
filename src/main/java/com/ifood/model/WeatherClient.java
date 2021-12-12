package com.ifood.model;

import java.util.List;
import java.util.TimeZone;

public class WeatherClient {
    private final Coord coord;
    private final List<Weather> weather;
    private final String base;
    private final Main main;
    private final int visibility;
    private final Wind wind;
    private final Clouds clouds;
    private final Long dt;
    private final Sys sys;
    private final TimeZone timezone;
    private final Long id;
    private final String name;
    private final int cod;

    public WeatherClient(Coord coord, List<Weather> weather, String base, Main main, int visibility, Wind wind, Clouds clouds, Long dt, Sys sys, TimeZone timeZone, Long id, String name, int cod) {
        this.coord = coord;
        this.weather = weather;
        this.base = base;
        this.main = main;
        this.visibility = visibility;
        this.wind = wind;
        this.clouds = clouds;
        this.dt = dt;
        this.sys = sys;
        this.timezone = timeZone;
        this.id = id;
        this.name = name;
        this.cod = cod;
    }

    public Coord getCoord() {
        return coord;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public String getBase() {
        return base;
    }

    public Main getMain() {
        return main;
    }

    public int getVisibility() {
        return visibility;
    }

    public Wind getWind() {
        return wind;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public Long getDt() {
        return dt;
    }

    public Sys getSys() {
        return sys;
    }

    public TimeZone getTimezone() {
        return timezone;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCod() {
        return cod;
    }
}
