package com.nabivach.movieland.util;

public enum Order {

    ASC("asc"), DESC("desc");

    private final String orderForQuery;

   Order(String orderForQuery) {
        this.orderForQuery = orderForQuery;
    }

    public String getOrderForQuery() {
        return orderForQuery;
    }

    public static Order getOrderForParams(String param) {
        if (Order.DESC.getOrderForQuery().equalsIgnoreCase(param)) {
            return Order.DESC;
        } else {
            return Order.ASC;
        }
    }
}
