package com.nabivach.movieland.util;

import com.nabivach.movieland.dto.MovieRequest;
import com.nabivach.movieland.dto.MovieSearchRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueryGenerator {

    @Autowired
    private String getAllMoviesSQL;

    @Autowired
    private String getMoviesSearchRequestSQL;

    private final String WHERE_CLAUSE = "where 1=1 ";

    public String getGeneratedQueryAllMovies(MovieRequest movieRequest) {
        return getAllMoviesSQL + " order by rating " + movieRequest.getRating() + ", price " + movieRequest.getPrice();
    }

    public String getGeneratedWhereClauseSearch(MovieSearchRequest movieSearchRequest) {

        StringBuilder sql = new StringBuilder(getMoviesSearchRequestSQL);
        sql.append(WHERE_CLAUSE);
        if (movieSearchRequest.getCountry() != null) {
            sql.append(" countries = '").append(movieSearchRequest.getCountry()).append("'");
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
}
