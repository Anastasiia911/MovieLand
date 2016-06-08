package com.nabivach.myentity;

/**
 * Created by grey3 on 08.06.2016.
 */
public class Movie {

    private int id;
    private String name;
    private char release_year;
    private char country;
    private char genre;
    private char description;
    private int rating;
    private int price;

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

    public char getRelease_year() {
        return release_year;
    }

    public void setRelease_year(char release_year) {
        this.release_year = release_year;
    }

    public char getCountry() {
        return country;
    }

    public void setCountry(char country) {
        this.country = country;
    }

    public char getGenre() {
        return genre;
    }

    public void setGenre(char genre) {
        this.genre = genre;
    }

    public char getDescription() {
        return description;
    }

    public void setDescription(char description) {
        this.description = description;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

