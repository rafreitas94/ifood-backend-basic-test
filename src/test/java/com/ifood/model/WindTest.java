package com.ifood.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WindTest {

    public static Wind instance() {
        return new Wind(
                4.03,
                146.0,
                4.24
        );
    }

    @Test
    void getWindInstance() {
        Wind wind = WindTest.instance();

        Assertions.assertEquals(4.03, wind.getSpeed());
        Assertions.assertEquals(146.0, wind.getDeg());
        Assertions.assertEquals(4.24, wind.getGust());
    }
}