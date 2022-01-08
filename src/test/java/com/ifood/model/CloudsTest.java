package com.ifood.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CloudsTest {

    public static Clouds instance() {
        return new Clouds(63);
    }

    @Test
    void getCloudInstance() {
        Clouds clouds = CloudsTest.instance();

        Assertions.assertEquals(63, clouds.getAll());
    }
}