package com.nabivach.movieland.util;

import com.nabivach.movieland.dto.ReviewDeletionRequest;
import com.nabivach.movieland.dto.ReviewRequest;
import com.nabivach.movieland.dto.MovieSearchRequest;
import junit.framework.TestCase;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class QueryGeneratorTest extends TestCase {

    private QueryGenerator queryGenerator = new QueryGenerator();

    public void testGetMoviesSearchRequestSQL() throws Exception {
        queryGenerator.setGetMoviesSearchRequestPrefix("SELECT DISTINCT movie.id, movie.name, movie.original_name, movie.release_year, movie.rating FROM movie\n" +
                "    join movie_ganre on movie.id = movie_ganre.movie_id\n" +
                "    join movie_country on movie.id = movie_country.movie_id\n" +
                "    join genre on genre.id = movie_ganre.genre_id\n" +
                "    join country on country.id = movie_country.country_id");

        MovieSearchRequest movieSearchRequest = mock(MovieSearchRequest.class);
        when(movieSearchRequest.getCountry()).thenReturn("USA");
        when(movieSearchRequest.getGenre()).thenReturn("дама");
        when(movieSearchRequest.getReleaseYear()).thenReturn(1900);
        when(movieSearchRequest.getTitle()).thenReturn("Green mile");
        assertEquals(queryGenerator.getMoviesSearchRequestSQL(movieSearchRequest), "SELECT DISTINCT movie.id, movie.name, movie.original_name, movie.release_year, movie.rating FROM movie\n" +
                "    join movie_ganre on movie.id = movie_ganre.movie_id\n" +
                "    join movie_country on movie.id = movie_country.movie_id\n" +
                "    join genre on genre.id = movie_ganre.genre_id\n" +
                "    join country on country.id = movie_country.country_id where 1=1  and countries = 'USA' and genre = 'дама' and title = 'Green mile' and year = 1900");
    }


    public void testAddReviewRequestSQL() throws Exception {
        queryGenerator.setAddReviewSQL("insert into review (movieuser_id,movie_id, description) values (");
        ReviewRequest reviewRequest = mock(ReviewRequest.class);
        when(reviewRequest.getAuthId()).thenReturn(5);
        when(reviewRequest.getMovieId()).thenReturn(1);
        when(reviewRequest.getReview()).thenReturn("Fucking Perfect !!!!!!!!");
        assertEquals(queryGenerator.addReviewRequestSQL(reviewRequest),"insert into review (movieuser_id,movie_id, description) values (5,1,'Fucking Perfect !!!!!!!!')");
    }

    public void testCheckReviewOwnedByUser() throws Exception {
        queryGenerator.setCheckReviewOwnedByUserSQL("select count(*) from review rv where rv.movieuser_id = ");
        int userId =1;
        ReviewDeletionRequest reviewDeletionRequest = mock(ReviewDeletionRequest.class);
        when (reviewDeletionRequest.getAuthToken()).thenReturn("55");
        when(reviewDeletionRequest.getReviewId()).thenReturn(7);
        assertEquals(queryGenerator.checkReviewOwnedByUserSQL(userId,reviewDeletionRequest),"select count(*) from review rv where rv.movieuser_id = 1 and rv.id= 7");

    }

    public void testDeleteReviewRequestSQL() throws Exception {
        queryGenerator.setDeleteReviewRequestSQL("delete from review r where r.id = ");
        ReviewDeletionRequest reviewDeletionRequest = mock(ReviewDeletionRequest.class);
        when (reviewDeletionRequest.getReviewId()).thenReturn(7);
        assertEquals(queryGenerator.deleteReviewRequestSQL(reviewDeletionRequest), "delete from review r where r.id = 7");

    }
}