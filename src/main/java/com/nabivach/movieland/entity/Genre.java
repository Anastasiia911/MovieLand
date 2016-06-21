package com.nabivach.movieland.entity;

public class Genre {

    //  Spring scheduled;

    private int id;
    private String name;
    //private localDatetime lastRefreshDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Genre { id =" + id + ", name=" + name + '\'' + '}';
    }
}