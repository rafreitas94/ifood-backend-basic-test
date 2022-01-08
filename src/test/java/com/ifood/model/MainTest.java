package com.ifood.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MainTest {

    public static Main instance() {
        return new Main(
                295.38,
                1016.0,
                76.0,
                295.64,
                295.38,
                297.05
        );
    }

    @Test
    void getMainInstance() {
        Main main = MainTest.instance();

        Assertions.assertEquals(295.38, main.getTemp());
        Assertions.assertEquals(1016.0, main.getFeelsLike());
        Assertions.assertEquals(76, main.getTempMin());
        Assertions.assertEquals(295.64, main.getTempMax());
        Assertions.assertEquals(295.38, main.getPressure());
        Assertions.assertEquals(297.05, main.getHumidity());
    }
}