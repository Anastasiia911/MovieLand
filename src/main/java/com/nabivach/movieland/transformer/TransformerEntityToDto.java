package com.nabivach.movieland.transformer;

import com.nabivach.movieland.dao.MovieDao;
import com.nabivach.movieland.dto.MovieByIdDto;
import com.nabivach.movieland.dto.MoviePreviewDto;
import com.nabivach.movieland.entity.Movie;
import com.nabivach.movieland.service.CountryService;
import com.nabivach.movieland.service.GenreService;
import com.nabivach.movieland.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TransformerEntityToDto {

    @Autowired
    private MovieDao movieDao;

    @Autowired
    private GenreService genreService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private ReviewService reviewService;

    List<MoviePreviewDto> moviePreviewDtoList = new ArrayList<MoviePreviewDto>();
    List<Movie> movies = movieDao.getAllMovies(); //
    List<Integer> moviesIdList = movieDao.getMoviesId();

    public List<Integer> getIdAllMovies() {
        for (Movie movie : movies) {
            moviesIdList.add(movie.getId());
        }
        return moviesIdList;
    }

    public List<MoviePreviewDto> enrichMoviePreviewDto() {
        MoviePreviewDto moviePreviewDto = new MoviePreviewDto();
        List<Movie> movies = movieDao.getAllMovies();
        List<Integer> moviesIdList = new ArrayList<Integer>();

        for (Movie movie : movies) {
            moviesIdList.add(movie.getId());
        }

        for (Movie movie : movies) {

            moviePreviewDto.setName(movie.getName());
            moviePreviewDto.setOriginalName(movie.getOriginalName());
            moviePreviewDto.setReleaseYear(movie.getReleaseYear());
            moviePreviewDto.setGenre(genreService.getGenresForMovie(movie.getId()));
            moviePreviewDto.setRating(movie.getRating());
            moviePreviewDtoList.add(moviePreviewDto);
        }
        return moviePreviewDtoList;
    }

    public MovieByIdDto enrichMovieByIdDto() {

        Movie movie = movieDao.getMovieById();
        MovieByIdDto movieByIdDto = new MovieByIdDto();
        movieByIdDto.setName(movie.getName());
        movieByIdDto.setOriginalName(movie.getOriginalName());
        movieByIdDto.setReleaseYear(movie.getReleaseYear());
        movieByIdDto.setCountry(countryService.getCountryForMovies(movie.getId()));
        movieByIdDto.setGenre(genreService.getGenresForMovie(movie.getId()));
        movieByIdDto.setDescription(movie.getDescription());
        movieByIdDto.setRating(movie.getRating());
        movieByIdDto.setPrice(movie.getPrice());
        movieByIdDto.setReview(reviewService.getReviewForMovies(movie.getId()));

        return movieByIdDto;
    }

}
