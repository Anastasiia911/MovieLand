package com.nabivach.movieland.service.impl;

import com.nabivach.movieland.entity.Movie;
import com.nabivach.movieland.service.MovieService;
import com.nabivach.movieland.util.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import java.util.List;


@Service("performanceLoggingMovieService")
public class PerformanceLoggingMovieService implements MovieService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PerformanceLoggingMovieService.class);

    @Autowired
    @Qualifier("genericMovieService")
    private MovieService movieService;

    @Override
    public List<Movie> getAllMovies(Order rating, Order price) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        List<Movie> movies = movieService.getAllMovies(rating,price);
        stopWatch.stop();
        LOGGER.debug("All Movies in JSON were received. It took {} ms ", stopWatch.getTotalTimeMillis());
        return movies;
    }

    @Override
    public Movie getMovieById() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Movie movie = movieService.getMovieById();
        stopWatch.stop();
        LOGGER.debug("All Movies in JSON were received. It took {} ms ", stopWatch.getTotalTimeMillis());
        return movie;
    }
}
