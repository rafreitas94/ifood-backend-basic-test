package com.ifood.model;

public class Wind {
    private final Double speed;
    private final Double deg;
    private final Double gust;

    public Wind(Double speed, Double deg, Double gust) {
        this.speed = speed;
        this.deg = deg;
        this.gust = gust;
    }

    public Double getSpeed() {
        return speed;
    }

    public Double getDeg() {
        return deg;
    }

    public Double getGust() {
        return gust;
    }
}
