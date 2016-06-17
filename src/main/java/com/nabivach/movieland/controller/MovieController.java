package com.nabivach.movieland.controller;

import com.nabivach.movieland.dto.MovieDto;
import com.nabivach.movieland.dto.MoviePreviewDto;
import com.nabivach.movieland.dto.transformer.ListTransformer;
import com.nabivach.movieland.dto.transformer.MovieDtoTransformer;
import com.nabivach.movieland.dto.transformer.MoviePreviewDtoTransformer;
import com.nabivach.movieland.entity.Movie;
import com.nabivach.movieland.service.impl.PerformanceLoggingMovieService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;

@RequestMapping(name = "/v1")
@Controller
public class MovieController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);

    @Autowired
    private PerformanceLoggingMovieService performanceLoggingMovieService;

    @Autowired
    private MoviePreviewDtoTransformer moviePreviewDtoTransformer;

    @Autowired
    private MovieDtoTransformer movieDtoTransformer;

    @RequestMapping(name = "/movies", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<MoviePreviewDto> getMovieListJson() {
        LOGGER.debug("Starting getting all movies in JSON");

        List<Movie> movies = performanceLoggingMovieService.getAllMovies();

        ListTransformer<Movie, MoviePreviewDto> moviePreviewDtoListTransformer = new ListTransformer<>(moviePreviewDtoTransformer);

        return moviePreviewDtoListTransformer.transformToDto(movies);
    }

    @RequestMapping(name = "movie/{movieId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public MovieDto getMovieByIdJson() {
        LOGGER.debug("Starting getting movies by id in JSON");

        Movie movie = performanceLoggingMovieService.getMovieById();

        MovieDto movieDto = movieDtoTransformer.transformToDto(movie);

        return movieDto;
    }
}


