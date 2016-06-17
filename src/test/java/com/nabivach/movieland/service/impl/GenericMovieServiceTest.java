package com.nabivach.movieland.service.impl;

import com.nabivach.movieland.dao.MovieDao;
import com.nabivach.movieland.dto.MoviePreviewDto;
import com.nabivach.movieland.entity.Movie;
import com.nabivach.movieland.service.CountryService;
import com.nabivach.movieland.service.GenreService;
import com.nabivach.movieland.service.ReviewService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GenericMovieServiceTest {

    @Mock
    MovieDao movieDao;

    @Mock
    GenreService genreService;

    @Mock
    CountryService serviceCountry;

    @Mock
    ReviewService reviewService;

    @Before
    public void setUp() throws Exception {

       Movie testMovie = new Movie();
        testMovie.setName("test movie");
        testMovie.setOriginalName("original name");
        testMovie.setReleaseYear(2000);
        testMovie.setRating(9.9);
        testMovie.setDescription("test description");

    }

    @Test
    public void enrichMoviePreviewDto() throws Exception {
        //Prepare
        Movie testMovie = new Movie();
        MoviePreviewDto moviePreviewDto = new MoviePreviewDto();
        when(genreService.getGenresForMovie(testMovie.getId())).thenReturn(null);

        //Execute
        moviePreviewDto.setName(testMovie.getName());
        //moviePreviewDto.setGenre();

        //Test
        assertEquals(testMovie.getName(),moviePreviewDto.getName());
    }

    @Test
    public void enrichMovieByIdDto() throws Exception {

    }
}

