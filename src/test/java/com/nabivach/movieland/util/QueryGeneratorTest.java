package com.nabivach.movieland.util;

import com.nabivach.movieland.dto.MovieSearchRequest;
import junit.framework.TestCase;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class QueryGeneratorTest extends TestCase {

    private QueryGenerator queryGenerator = new QueryGenerator();

    public void testGetMoviesSearchRequestSQL() throws Exception {
        queryGenerator.setGetMoviesSearchRequestPrefix("SELECT DISTINCT movie FROM movie\n" +
                "    join movie_ganre on movie.id = movie_ganre.movie_id\n" +
                "    join movie_country on movie.id = movie_country.movie_id\n" +
                "    join genre on genre.id = movie_ganre.genre_id\n" +
                "    join country on country.id = movie_country.country_id");

        MovieSearchRequest movieSearchRequest = mock(MovieSearchRequest.class);
        when(movieSearchRequest.getCountry()).thenReturn("USA");
        when(movieSearchRequest.getGenre()).thenReturn("дама");
        when(movieSearchRequest.getReleaseYear()).thenReturn(1900);
        when(movieSearchRequest.getTitle()).thenReturn("Green mile");
        assertEquals(queryGenerator.getMoviesSearchRequestSQL(movieSearchRequest), "SELECT DISTINCT movie FROM movie\n" +
                "    join movie_ganre on movie.id = movie_ganre.movie_id\n" +
                "    join movie_country on movie.id = movie_country.movie_id\n" +
                "    join genre on genre.id = movie_ganre.genre_id\n" +
                "    join country on country.id = movie_country.country_id where 1=1  and countries = 'USA' and genre = 'дама' and title = 'Green mile' and year = 1900");
    }
}