package com.ifood.model;

public class Coord {
    private final Double lon;
    private final Double lat;

    public Coord(Double lon, Double lat) {
        this.lon = lon;
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public Double getLat() {
        return lat;
    }
}
