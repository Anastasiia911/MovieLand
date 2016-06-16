package com.nabivach.movieland.service.impl;

import com.nabivach.movieland.dao.MovieDao;
import com.nabivach.movieland.dto.MovieByIdDto;
import com.nabivach.movieland.dto.MoviePreviewDto;
import com.nabivach.movieland.entity.Country;
import com.nabivach.movieland.entity.Genre;
import com.nabivach.movieland.entity.Movie;
import com.nabivach.movieland.service.ServiceGenre;
import com.nabivach.movieland.service.ServiceCountry;
import com.nabivach.movieland.service.ServiceMovie;
import com.nabivach.movieland.service.ServiceReview;
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
    @Autowired
    private ServiceReview serviceReview;

    public List<MoviePreviewDto> getAllMovies() {
        List<MoviePreviewDto> movies = enrichMoviePreviewDto();

        return movies;
    }

    public MovieByIdDto getMovieById() {
        MovieByIdDto movie = enrichMovieByIdDto();
        return movie;
    }

    public List<MoviePreviewDto> enrichMoviePreviewDto() {
        MoviePreviewDto moviePreviewDto = new MoviePreviewDto();
        List<MoviePreviewDto> moviePreviewDtoList = null;

        List<Movie> movies = movieDao.getAllMovies();
        for (Movie movie : movies) {
            moviePreviewDto.setName(movie.getName());
            moviePreviewDto.setOriginal_name(movie.getOriginal_name());
            moviePreviewDto.setRelease_year(movie.getRelease_year());
            moviePreviewDto.setGenre(serviceGenre.getGenresForMovies(movie.getId()));
            moviePreviewDto.setRating(movie.getRating());
            moviePreviewDtoList.add(moviePreviewDto);
        }
        return moviePreviewDtoList;
    }

    public MovieByIdDto enrichMovieByIdDto() {
        Movie movie = movieDao.getMovieById();
        MovieByIdDto movieByIdDto = new MovieByIdDto();
        movieByIdDto.setName(movie.getName());
        movieByIdDto.setOriginal_name(movie.getOriginal_name());
        movieByIdDto.setRelease_year(movie.getRelease_year());
        movieByIdDto.setCountry(serviceCountry.getCountryForMovies(movie.getId()));
        movieByIdDto.setGenre(serviceGenre.getGenresForMovies(movie.getId()));
        movieByIdDto.setDescription(movie.getDescription());
        movieByIdDto.setRating(movie.getRating());
        movieByIdDto.setPrice(movie.getPrice());
        movieByIdDto.setReview(serviceReview.getReviewForMovies(movie.getId()));

        return movieByIdDto;
    }

}
