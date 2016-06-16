package com.nabivach.movieland.dto;

import com.nabivach.movieland.entity.Country;
import com.nabivach.movieland.entity.Genre;
import com.nabivach.movieland.entity.Review;

import java.util.List;

public class MovieByIdDto {

    private String name;
    private String original_name;
    private int release_year;
    private List<Country> country;
    private List<Genre> genre;
    private String description;
    private double rating;
    private double price;
    private List<Review> review;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Review> getReview() {
        return review;
    }

    public void setReview(List<Review> review) {
        this.review = review;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Genre> getGenre() {
        return genre;
    }

    public void setGenre(List<Genre> genre) {
        this.genre = genre;
    }

    public List<Country> getCountry() {
        return country;
    }

    public void setCountry(List<Country> country) {
        this.country = country;
    }

    public int getRelease_year() {
        return release_year;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }

    public String getOriginal_name() {
        return original_name;
    }

    public void setOriginal_name(String original_name) {
        this.original_name = original_name;
    }

    @Override
    public String toString() {
        return "Movie { name=" + name + ", release_year=" + release_year + ", country" + country + " , genre"
                + genre + ", description=" + description + ", rating=" + rating + ", price=" + price + '\''+ ", review = " +review + '}';
    }
}

