package com.ifood.model;

public class Clouds {
    private int all;

    /**
     * @deprecated (since version 1.0, used by feign)
     */
    @Deprecated(since = "1.0")
    public Clouds() {
    }

    public Clouds(int all) {
        this.all = all;
    }

    public int getAll() {
        return all;
    }
}
