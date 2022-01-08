package com.ifood.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SysTest {

    public static Sys instance() {
        return new Sys(
                2L,
                2033898L,
                "BR",
                1639815311L,
                1639864248L
        );
    }

    @Test
    void getSysInstance() {
        Sys sys = SysTest.instance();

        Assertions.assertEquals(2L, sys.getType());
        Assertions.assertEquals(2033898L, sys.getId());
        Assertions.assertEquals("BR", sys.getCountry());
        Assertions.assertEquals(1639815311L, sys.getSunrise());
        Assertions.assertEquals(1639864248L, sys.getSunset());
    }

}