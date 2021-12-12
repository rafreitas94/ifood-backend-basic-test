package com.ifood.model;

public class Sys {
    private final Long type;
    private final Long id;
    private final String country;
    private final Long sunrise;
    private final Long sunset;

    public Sys(Long type, Long id, String country, Long sunrise, Long sunset) {
        this.type = type;
        this.id = id;
        this.country = country;
        this.sunrise = sunrise;
        this.sunset = sunset;
    }

    public Long getType() {
        return type;
    }

    public Long getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public Long getSunrise() {
        return sunrise;
    }

    public Long getSunset() {
        return sunset;
    }
}
