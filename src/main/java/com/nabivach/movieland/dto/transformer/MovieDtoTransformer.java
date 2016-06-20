package com.nabivach.movieland.dto.transformer;

import com.nabivach.movieland.dto.MovieDto;
import com.nabivach.movieland.entity.Movie;
import com.nabivach.movieland.service.CountryService;
import com.nabivach.movieland.service.GenreService;
import com.nabivach.movieland.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by anabivach on 17/06/2016.
 */
@Component("movieDtoTransformer")
public class MovieDtoTransformer implements Transformer<Movie, MovieDto> {

    @Autowired
    private GenreService genreService;

    public void setGenreService(GenreService genreService) {
        this.genreService = genreService;
    }

    @Autowired
    private CountryService countryService;

    public void setCountryService(CountryService countryService){
        this.countryService =countryService;
    }

    @Autowired
    private ReviewService reviewService;

    public void setReviewService(ReviewService reviewService){
        this.reviewService =reviewService;
    }


    public MovieDto transformToDto(Movie movie) {
        MovieDto movieDto = new MovieDto();
        movieDto.setName(movie.getName());
        movieDto.setOriginalName(movie.getOriginalName());
        movieDto.setReleaseYear(movie.getReleaseYear());
        movieDto.setCountry(countryService.getCountryForMovies(movie.getId()));
        movieDto.setGenre(genreService.getGenresForMovie(movie.getId()));
        movieDto.setDescription(movie.getDescription());
        movieDto.setRating(movie.getRating());
        movieDto.setPrice(movie.getPrice());
        movieDto.setReview(reviewService.getReviewForMovies(movie.getId()));
        return movieDto;
    }
}
