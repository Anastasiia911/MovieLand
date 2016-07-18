package com.nabivach.movieland.service;

import com.nabivach.movieland.dto.MovieByIdRequest;
import com.nabivach.movieland.dto.MovieRequest;
import com.nabivach.movieland.dto.MovieSearchRequest;
import com.nabivach.movieland.entity.Movie;
import com.nabivach.movieland.util.Order;

import java.util.List;

//SERVICE LAYER is there to provide logic to operate on the data sent to and from the DAO

public interface MovieService {

    List<Movie> getAllMovies(MovieRequest movieRequest);
    Movie getMovieById(MovieByIdRequest movieByIdRequest);
    List <Movie> getMoviesSearch(MovieSearchRequest movieSearchRequest);
}
