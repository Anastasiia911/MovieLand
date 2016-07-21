package com.nabivach.movieland.controller;

import com.nabivach.movieland.dto.*;
import com.nabivach.movieland.dto.transformer.ListTransformer;
import com.nabivach.movieland.dto.transformer.MovieDtoTransformer;
import com.nabivach.movieland.dto.transformer.MoviePreviewDtoTransformer;
import com.nabivach.movieland.dto.transformer.MovieRequestTransformer;
import com.nabivach.movieland.entity.Movie;
import com.nabivach.movieland.service.impl.PerformanceLoggingMovieService;
import com.nabivach.movieland.util.deserializer.JsonParse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;
import java.util.List;

@RequestMapping("/v1")
@Controller
public class MovieController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);

    @Autowired
    private PerformanceLoggingMovieService performanceLoggingMovieService;


    @Autowired
    private MoviePreviewDtoTransformer moviePreviewDtoTransformer;

    @Autowired
    private MovieDtoTransformer movieDtoTransformer;

    @Autowired
    private MovieRequestTransformer movieRequestTransformer;


    @Autowired
    private JsonParse jsonReader;

    @RequestMapping(value = "/movies", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<MoviePreviewDto> getMovieListJson(@RequestParam(required = false) String rating, @RequestParam(required = false) String price, @RequestParam(defaultValue = "1") int pageNumber,
                                                  @RequestParam(defaultValue = "UAH") String currency) {
        LOGGER.debug("Starting getting all movies in JSON");
        MovieRequest movieRequest = movieRequestTransformer.getMovieRequest(rating, price, pageNumber, currency);
        List<Movie> movies = performanceLoggingMovieService.getAllMovies(movieRequest);
        ListTransformer<Movie, MoviePreviewDto> moviePreviewDtoListTransformer = new ListTransformer<>(moviePreviewDtoTransformer);
        return moviePreviewDtoListTransformer.transformToDto(movies);
    }

    @RequestMapping(value = "/movie/{movieId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public MovieDto getMovieByIdJson(@PathVariable int movieId, @RequestParam(defaultValue = "UAH") String currency) {
        LOGGER.debug("Starting getting movies by id in JSON");
        MovieByIdRequest movieByIdRequest =movieRequestTransformer.getMovieByIdRequest(movieId, currency);
        Movie movie = performanceLoggingMovieService.getMovieById(movieByIdRequest);
        MovieDto movieDto = movieDtoTransformer.transformToDto(movie);
        return movieDto;
    }

    @RequestMapping(value = "/movies/search", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<MoviePreviewDto> getMoviesSearchJson(@RequestBody String json) throws IOException {
        LOGGER.debug("Received request for search from user..");
        MovieSearchRequest movieSearchRequest = jsonReader.parseJson(json, MovieSearchRequest.class);
        LOGGER.debug("Starting getting movies: user search .. ");
        List<Movie> movieSearch = performanceLoggingMovieService.getMoviesSearch(movieSearchRequest);
        ListTransformer<Movie, MoviePreviewDto> moviePreviewDtoListTransformer = new ListTransformer<>(moviePreviewDtoTransformer);
        List<MoviePreviewDto> movieSearchList = moviePreviewDtoListTransformer.transformToDto(movieSearch);
        LOGGER.debug("Stop getting movies: user search .. ");
        return movieSearchList;
    }
}


