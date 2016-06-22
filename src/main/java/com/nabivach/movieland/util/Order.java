package com.nabivach.movieland.util;

/**
 * Created by anabivach on 22/06/2016.
 */
public enum Order {

    ASCENDING("asc"), DESCENDING("desc");

    private final String sql;

    private Order(String sql) {
        this.sql = sql;
    }

    public String getSql() {
        return sql;
    }

    public static Order parseString(String param) {
        if (Order.DESCENDING.getSql().equalsIgnoreCase(param)) {
            return Order.DESCENDING;
        } else {
            return Order.ASCENDING;
        }
    }
}
