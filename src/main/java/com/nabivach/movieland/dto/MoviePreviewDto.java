package com.nabivach.movieland.dto;

import com.nabivach.movieland.entity.Genre;

import java.util.List;

public class MoviePreviewDto {

    private String name;
    private String originalName;
    private int releaseYear;
    private double rating;
    private List<Genre> genre;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
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

    @Override
    public String toString() {
        return "Movie { name=" + name + ", releaseYear=" + releaseYear + " , rating"
                + rating + " , genre"
                + genre + '}';
    }
}

