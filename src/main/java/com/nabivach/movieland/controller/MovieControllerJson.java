package com.nabivach.movieland.controller;

import com.nabivach.movieland.dto.MovieByIdDto;
import com.nabivach.movieland.dto.MoviePreviewDto;
import com.nabivach.movieland.entity.Movie;
import com.nabivach.movieland.service.ServiceMovie;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;

@RequestMapping(name = "/v1")
@Controller
public class MovieControllerJson {

    private static final Logger LOGGER = LoggerFactory.getLogger(MovieControllerJson.class);

    @Autowired
    private ServiceMovie serviceMovie;

    @RequestMapping(name = "/movies", method = RequestMethod.GET, produces = "application/json; UTF-8")
    @ResponseBody
    public List<MoviePreviewDto> getMovieListInJSON() {
        LOGGER.debug("Starting getting All Movies in JSON..");
        long startTime = System.currentTimeMillis();

        List<MoviePreviewDto> movieList = serviceMovie.getAllMovies();

        long endTime = System.currentTimeMillis();
        long time = endTime - startTime;
        LOGGER.debug("All Movies in JSON were received. It took {} ms ", time);

        return movieList;
    }

    @RequestMapping(name = "movie/{movieId}", produces = "application/json; UTF-8")
    @ResponseBody
    public MovieByIdDto getMovieByIdInJSON() {
        LOGGER.debug("Starting getting movies by id in JSON");
        long startTime = System.currentTimeMillis();

        MovieByIdDto movie = serviceMovie.getMovieById();

        long endTime = System.currentTimeMillis();
        long time = endTime - startTime;
        LOGGER.debug("ALL Movies by id were received. {} ms ", time);
        return movie;
    }


}


