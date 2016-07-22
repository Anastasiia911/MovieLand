package com.nabivach.movieland.service.impl;

import com.nabivach.movieland.dao.MovieDao;
import com.nabivach.movieland.dto.MovieByIdRequest;
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
    @Autowired
    private CachingCurrencyService cachingCurrencyService;

    public List<Movie> getAllMovies(MovieRequest movieRequest) {
        List<Movie> moviesList  = movieDao.getAllMovies(movieRequest);
        for (Movie movie:moviesList){
            movie.setPrice(getConvertedPrice(movie.getPrice(), movieRequest.getCurrency()));
        }
        return moviesList;
    }

    public Movie getMovieById(MovieByIdRequest movieByIdRequest) {
        Movie movie = movieDao.getMovieById(movieByIdRequest);
        movie.setGenre(cachingGenreService.getGenresForMovie(movieByIdRequest));
        movie.setCountry(countryService.getCountryForMovies(movieByIdRequest));
        movie.setReview(reviewService.getReviewForMovies(movieByIdRequest));
        movie.setPrice(getConvertedPrice(movie.getPrice(), movieByIdRequest.getCurrency()));
        return movie;
    }

    public List<Movie> getMoviesSearch(MovieSearchRequest movieSearchRequest) {
        return movieDao.getMoviesSearch(movieSearchRequest);
    }

    private double getConvertedPrice(Double price, String ccy){
        return price * cachingCurrencyService.getRateByRequest(ccy);
    }

}

