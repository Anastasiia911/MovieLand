package com.nabivach.movieland.util;

public enum Order {

    ASCENDING("asc"), DESCENDING("desc");

    private final String orderForQuery;

   Order(String orderForQuery) {
        this.orderForQuery = orderForQuery;
    }

    public String getOrderForQuery() {
        return orderForQuery;
    }

    public static Order getOrderForParams(String param) {
        if (Order.DESCENDING.getOrderForQuery().equalsIgnoreCase(param)) {
            return Order.DESCENDING;
        } else {
            return Order.ASCENDING;
        }
    }
}
