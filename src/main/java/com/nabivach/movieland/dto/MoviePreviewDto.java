package com.nabivach.movieland.dto;

import com.nabivach.movieland.entity.Country;
import com.nabivach.movieland.entity.Genre;

import java.util.List;

public class MoviePreviewDto {


    private String name;
    private String original_name;
    private int release_year;
    private double rating;
    private List<Genre> genre;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOriginal_name() {
        return original_name;
    }

    public void setOriginal_name(String original_name) {
        this.original_name = original_name;
    }

    public int getRelease_year() {
        return release_year;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public List<Genre> getGenre() {
        return genre;
    }

    public void setGenre(List<Genre> genre) {
        this.genre = genre;
    }

    // title (on both languages), year of release, rating, genre.
    @Override
    public String toString() {
        return "Movie { name=" + name + ", release_year=" + release_year + " , rating"
                + rating + " , genre"
                + genre + '}';
    }
}

