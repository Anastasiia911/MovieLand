package com.nabivach.movieland.service;

import com.nabivach.movieland.entity.Movie;

import java.util.List;

//SERVICE LAYER is there to provide logic to operate on the data sent to and from the DAO

public interface MovieService {

    List<Movie> getAllMovies();

    Movie getMovieById();
}
