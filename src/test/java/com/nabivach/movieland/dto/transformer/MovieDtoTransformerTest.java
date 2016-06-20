package com.nabivach.movieland.dto.transformer;

import com.nabivach.movieland.dto.MovieDto;
import com.nabivach.movieland.entity.Country;
import com.nabivach.movieland.entity.Genre;
import com.nabivach.movieland.entity.Movie;
import com.nabivach.movieland.entity.Review;
import com.nabivach.movieland.service.CountryService;
import com.nabivach.movieland.service.GenreService;
import com.nabivach.movieland.service.ReviewService;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MovieDtoTransformerTest {

    @Test
    public void testTransformToDto() throws Exception {
//Prepare

        Country country = new Country();
        country.setName("USA");
        country.setId(1);
        CountryService countryService = mock(CountryService.class);
        when(countryService.getCountryForMovies(anyInt())).thenReturn(Arrays.asList(country));

        Review review = new Review();
        review.setId(1);
        review.setDescription("Good movie");
        ReviewService reviewService = mock(ReviewService.class);
        when(reviewService.getReviewForMovies(anyInt())).thenReturn(Arrays.asList(review));

        Genre genre = new Genre();
        genre.setId(1);
        genre.setName("drama");
        GenreService genreService = mock(GenreService.class);
        when(genreService.getGenresForMovie(anyInt())).thenReturn(Arrays.asList(genre));

        Movie testMovie = new Movie();
        testMovie.setName("Testmovie");
        testMovie.setOriginalName("Movie");
        testMovie.setGenre(genreService.getGenresForMovie(1));
        testMovie.setReleaseYear(2000);
        testMovie.setCountry(countryService.getCountryForMovies(1));
        testMovie.setRating(9);
//Execute
        MovieDtoTransformer movieDtoTransformer = new MovieDtoTransformer();
        movieDtoTransformer.setGenreService(genreService);
        movieDtoTransformer.setCountryService(countryService);
        movieDtoTransformer.setReviewService(reviewService);
        MovieDto actualMovieDto = movieDtoTransformer.transformToDto(testMovie);

        //Check
        assertEquals(actualMovieDto.getName(), testMovie.getName());
        assertEquals(actualMovieDto.getCountry(),testMovie.getCountry());
        assertEquals(actualMovieDto.getGenre(), testMovie.getGenre());
        assertEquals(actualMovieDto.getDescription(),testMovie.getDescription());
        assertEquals(actualMovieDto.getReleaseYear(),testMovie.getReleaseYear());
        assertEquals(actualMovieDto.getRating(),testMovie.getRating(),0.1);


    }

}