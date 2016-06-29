package com.nabivach.movieland.service.impl;

import com.nabivach.movieland.dao.MovieDao;
import com.nabivach.movieland.dto.MovieRequest;
import com.nabivach.movieland.dto.MovieSearchRequest;
import com.nabivach.movieland.entity.Movie;
import com.nabivach.movieland.service.CountryService;
import com.nabivach.movieland.service.MovieService;
import com.nabivach.movieland.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service ("genericMovieService")
public class GenericMovieService implements MovieService {

    @Autowired
    private MovieDao movieDao;
    @Autowired
    private CachingGenreService cachingGenreService;
    @Autowired
    private CountryService countryService;
    @Autowired
    private ReviewService reviewService;

    public List<Movie> getAllMovies(MovieRequest movieRequest) {
        return movieDao.getAllMovies(movieRequest);
    }

    public Movie getMovieById(int movieId) {
        Movie movie = movieDao.getMovieById(movieId);
        movie.setGenre(cachingGenreService.getGenresForMovie(movieId));
        movie.setCountry(countryService.getCountryForMovies(movieId));
        movie.setReview(reviewService.getReviewForMovies(movieId));
        return movie;
    }

    public List<Movie> getMoviesSearch(MovieSearchRequest movieSearchRequest) {
        return movieDao.getMoviesSearch(movieSearchRequest);
    }

}

