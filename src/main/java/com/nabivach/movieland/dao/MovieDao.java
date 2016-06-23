package com.nabivach.movieland.dao;

import com.nabivach.movieland.dto.MovieRequest;
import com.nabivach.movieland.entity.Movie;
import com.nabivach.movieland.util.Order;

import java.util.List;


//DAO as light as possible and exists to provide a connection to the DB

public interface MovieDao {
    List<Movie> getAllMovies(MovieRequest movieRequest);

    Movie getMovieById(int movieId);

    List<Integer> getMoviesIdList();
}
