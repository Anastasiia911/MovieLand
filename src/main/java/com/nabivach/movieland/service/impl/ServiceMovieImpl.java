package com.nabivach.movieland.service.impl;

import com.nabivach.movieland.dao.MovieDao;
import com.nabivach.movieland.entity.Movie;
import com.nabivach.movieland.service.ServiceGenre;
import com.nabivach.movieland.service.ServiceCountry;
import com.nabivach.movieland.service.ServiceMovie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceMovieImpl implements ServiceMovie {

    @Autowired
    private MovieDao movieDao;
    @Autowired
    private ServiceGenre serviceGenre;
    @Autowired
    private ServiceCountry serviceCountry;

    public List<Movie> getAllMovies() {
        List<Movie> movies = enrichMovies();

        return movies;
    }

    public List<Movie> enrichMovies() {
        List<Movie> movies = movieDao.getAllMovies();
        for (Movie movie : movies) {
            //movie.setCountry(serviceCountry.getCountryForMovies(movie.getId()));
            movie.setGenre(serviceGenre.getGenresForMovies(movie.getId()));
        }
        return movies;
    }
}
