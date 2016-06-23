package com.nabivach.movieland.service.impl;

import com.nabivach.movieland.dao.MovieDao;
import com.nabivach.movieland.dto.MovieRequest;
import com.nabivach.movieland.entity.Movie;
import com.nabivach.movieland.service.MovieService;
import com.nabivach.movieland.util.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("genericMovieService")
public class GenericMovieService implements MovieService {

    @Autowired
    private MovieDao movieDao;

    public List<Movie> getAllMovies(MovieRequest movieRequest) {
        return movieDao.getAllMovies(movieRequest);
    }

    public Movie getMovieById(int movieId) {
        return movieDao.getMovieById(movieId);
    }


}

