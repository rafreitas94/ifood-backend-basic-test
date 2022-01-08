package com.ifood.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CoordTest {

    public static Coord instance() {
        return new Coord(-46.565, -23.6939);
    }

    @Test
    void getCoordInstance() {
        Coord coord = CoordTest.instance();

        Assertions.assertEquals(-46.565, coord.getLon());
        Assertions.assertEquals(-23.6939, coord.getLat());
    }
}