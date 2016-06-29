package com.nabivach.movieland.dto.transformer;

import com.nabivach.movieland.dto.MovieDto;
import com.nabivach.movieland.entity.Movie;
import com.nabivach.movieland.service.CountryService;
import com.nabivach.movieland.service.GenreService;
import com.nabivach.movieland.service.ReviewService;
import com.nabivach.movieland.service.impl.CachingGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("movieDtoTransformer")
public class MovieDtoTransformer implements Transformer<Movie, MovieDto> {

    @Qualifier("cachingGenreService")
    @Autowired
    private CachingGenreService cachingGenreService;

    @Qualifier("genericGenreService")
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
        //movieDto.setGenre(genreService.getGenresForMovie(movie.getId()));
        movieDto.setGenre(cachingGenreService.getGenresForAllMovies().get(movie.getId()));
        movieDto.setDescription(movie.getDescription());
        movieDto.setRating(movie.getRating());
        movieDto.setPrice(movie.getPrice());
        movieDto.setReview(reviewService.getReviewForMovies(movie.getId()));
        return movieDto;
    }
}
