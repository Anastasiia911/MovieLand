package com.nabivach.movieland.dao;

import com.nabivach.movieland.entity.Movie;

import java.util.List;


//DAO as light as possible and exists to provide a connection to the DB

public interface MovieDao {
    List<Movie> getAllMovies();

    Movie getMovieById();

    List<Integer> getMoviesIdList();
}
