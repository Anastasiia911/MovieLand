package com.nabivach.movieland.controller;

import com.nabivach.movieland.entity.Movie;
import com.nabivach.movieland.service.ServiceMovie;
import com.nabivach.movieland.util.ConvertJson;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;

@Controller
public class MovieControllerJson {

    private static final Logger LOGGER = LoggerFactory.getLogger(MovieControllerJson.class);

    @Autowired
    private ServiceMovie serviceMovie;

    @Autowired
    private ConvertJson convertJson;

    @RequestMapping(name = "/v1/movies", method = RequestMethod.GET, produces = "application/json; UTF-8")
    @ResponseBody
    public String getMovieListInJSON() {
        LOGGER.debug("Starting getting All Movies in JSON..");
        long startTime = System.currentTimeMillis();
        List<Movie> movieList = serviceMovie.getAllMovies();
        long endTime = System.currentTimeMillis();
        long time = endTime - startTime;
        LOGGER.debug("All Movies in JSON were received. It took {} ms " + time);

        return convertJson.movieToJsonConverter(movieList);
    }

    @RequestMapping(name = "/v1/movies/{movieId}", produces = "UTF-8")
    @ResponseBody
    public String getMovieByIdInJSON() {
        LOGGER.debug("Starting getting movies by id in JSON");

        return null;
    }


}


