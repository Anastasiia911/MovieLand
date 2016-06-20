package com.nabivach.movieland.dto.transformer;

import com.nabivach.movieland.dto.MoviePreviewDto;
import com.nabivach.movieland.entity.Genre;
import com.nabivach.movieland.entity.Movie;
import com.nabivach.movieland.service.GenreService;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by anastasiia_911 on 6/19/16.
 */
public class MoviePreviewDtoTransformerTest {

    @Test
    public void testTransformToDto() throws Exception {
//Prepare

        Genre testGenre = new Genre();
        testGenre.setId(1);
        testGenre.setName("drama");
        GenreService genreService= mock(GenreService.class);
        when(genreService.getGenresForMovie(anyInt())).thenReturn(Arrays.asList(testGenre));


        Movie testMovie = new Movie();
        testMovie.setName("Testmovie");
        testMovie.setOriginalName("Movie");
        testMovie.setGenre(Arrays.asList(testGenre));
        testMovie.setReleaseYear(2000);
        testMovie.setRating(9);
        testMovie.setDescription("Good");

        MoviePreviewDtoTransformer moviePreviewDtoTransformer= new MoviePreviewDtoTransformer();
        moviePreviewDtoTransformer.setGenreService(genreService);

        MoviePreviewDto actualPreviewMovieDto = moviePreviewDtoTransformer.transformToDto(testMovie);

        //check
        assertEquals(actualPreviewMovieDto.getName(),testMovie.getName());
        assertEquals(actualPreviewMovieDto.getName(), testMovie.getName());
        assertEquals(actualPreviewMovieDto.getGenre(), testMovie.getGenre());
        assertEquals(actualPreviewMovieDto.getReleaseYear(),testMovie.getReleaseYear());
        assertEquals(actualPreviewMovieDto.getRating(),testMovie.getRating(),0.1);

    }
}