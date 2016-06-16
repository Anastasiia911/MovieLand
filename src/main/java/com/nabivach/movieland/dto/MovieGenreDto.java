package com.nabivach.movieland.dto;

import java.util.List;

public class MovieGenreDto {

    public int movieId;
    public List<String> genre;

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public List<String> getGenre() {
        return genre;
    }

    public void setGenre(List<String> genre) {
        this.genre = genre;
    }

    @Override
    public String toString(){
    return  "Review { movieId =" + movieId + ", genre=" + genre+ '}';
    }
}
