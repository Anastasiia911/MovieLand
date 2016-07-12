package com.nabivach.movieland.util;

import com.nabivach.movieland.dto.ReviewRequest;
import com.nabivach.movieland.dto.MovieRequest;
import com.nabivach.movieland.dto.MovieSearchRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueryGenerator {

    @Autowired
    private String getAllMoviesSQL;

    public void setGetMoviesSearchRequestPrefix(String getMoviesSearchRequestPrefix) {
        this.getMoviesSearchRequestPrefix = getMoviesSearchRequestPrefix;
    }

    public void setAddReviewSQL(String addReviewSQL) {
        this.addReviewSQL = addReviewSQL;
    }

    @Autowired
    private String getMoviesSearchRequestPrefix;


    @Autowired
    private String addReviewSQL;

    private final String WHERE_CLAUSE = " where 1=1 ";
    private int countMoviesPerPage = 5;

    public String getGeneratedQueryAllMovies(MovieRequest movieRequest) {
        StringBuilder sql = new StringBuilder(getAllMoviesSQL + " order by rating " + movieRequest.getRating() + ", price " + movieRequest.getPrice());
        sql.append(" LIMIT ");
        sql.append(countMoviesPerPage);
        sql.append(" OFFSET ");
        sql.append(countMoviesPerPage * (movieRequest.getPageNumber() - 1));

        return sql.toString();
    }

    public String getMoviesSearchRequestSQL(MovieSearchRequest movieSearchRequest) {
        StringBuilder sql = new StringBuilder(getMoviesSearchRequestPrefix);
        sql.append(WHERE_CLAUSE);
        if (movieSearchRequest.getCountry() != null) {
            sql.append(" and countries = '").append(movieSearchRequest.getCountry()).append("'");
        }
        if (movieSearchRequest.getGenre() != null) {
            sql.append(" and genre = '").append(movieSearchRequest.getGenre()).append("'");
        }
        if (movieSearchRequest.getTitle() != null) {
            sql.append(" and title = '").append(movieSearchRequest.getTitle()).append("'");
        }

        if (movieSearchRequest.getReleaseYear() != 0) {
            sql.append(" and year = ").append(movieSearchRequest.getReleaseYear());
        }

        return sql.toString();
    }

    public String addReviewRequestSQL(ReviewRequest reviewRequest) {
        StringBuilder sql = new StringBuilder(addReviewSQL);
       sql.append(reviewRequest.getAuthId());
        sql.append(",");
        sql.append(reviewRequest.getMovieId());
        sql.append(",'");
        sql.append(reviewRequest.getReview());
        sql.append("')");
        return sql.toString();
    }
}
