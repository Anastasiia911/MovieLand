package com.nabivach.movieland.service.impl;

import com.nabivach.movieland.dao.MovieDao;
import com.nabivach.movieland.dto.MovieByIdDto;
import com.nabivach.movieland.dto.MoviePreviewDto;
import com.nabivach.movieland.entity.Movie;
import com.nabivach.movieland.service.ServiceCountry;
import com.nabivach.movieland.service.ServiceGenre;
import com.nabivach.movieland.service.ServiceReview;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServiceMovieImplTest {

    @Mock
    MovieDao movieDao;

    @Mock
    ServiceGenre serviceGenre;

    @Mock
    ServiceCountry serviceCountry;

    @Mock
    ServiceReview serviceReview;

    @Before
    public void setUp() throws Exception {

       Movie testMovie = new Movie();
        testMovie.setName("test movie");
        testMovie.setOriginal_name("original name");
        testMovie.setRelease_year(2000);
        testMovie.setRating(9.9);
        testMovie.setDescription("test description");

    }

    @Test
    public void enrichMoviePreviewDto() throws Exception {
        //Prepare
        Movie testMovie = new Movie();
        MoviePreviewDto moviePreviewDto = new MoviePreviewDto();
        when(serviceGenre.getGenresForMovies(testMovie.getId())).thenReturn(null);

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

