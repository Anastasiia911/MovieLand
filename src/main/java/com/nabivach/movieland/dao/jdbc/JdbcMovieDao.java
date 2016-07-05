package com.nabivach.movieland.dao.jdbc;

import com.nabivach.movieland.dao.MovieDao;
import com.nabivach.movieland.dao.jdbc.mapper.MovieRowMapper;
import com.nabivach.movieland.dto.MovieRequest;
import com.nabivach.movieland.dto.MovieSearchRequest;
import com.nabivach.movieland.entity.Movie;
import com.nabivach.movieland.util.QueryGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository //Mark as SPRING bean

public class JdbcMovieDao implements MovieDao {

    private final static Logger LOGGER = LoggerFactory.getLogger(JdbcMovieDao.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private QueryGenerator getGeneratedQuery;

    @Autowired
    private String getMovieByIdSQL;

    private static MovieRowMapper movieRowMapper = new MovieRowMapper();

    public List<Movie> getAllMovies(MovieRequest movieRequest) {
        LOGGER.debug("Starting execution SQL query...");
        long startTime = System.currentTimeMillis();
        List<Movie> allMovies = jdbcTemplate.query(getGeneratedQuery.getGeneratedQueryAllMovies(movieRequest), movieRowMapper);
        long time = System.currentTimeMillis() - startTime;
        LOGGER.info("Result AllMovies was received. It took {} ms", time);
        LOGGER.debug("Finish execution ...");
        return allMovies;
    }

    public Movie getMovieById(int movieId) {
        LOGGER.debug("Starting execution SQL query getMovieById...");
        long startTime = System.currentTimeMillis();
        Movie movie = jdbcTemplate.queryForObject(getMovieByIdSQL, new Object[]{movieId}, movieRowMapper);
        long time = System.currentTimeMillis() - startTime;
        LOGGER.info("Result AllMovies was received. It took {} ms", time);
        return movie;
    }

    public List<Movie> getMoviesSearch(MovieSearchRequest movieSearchRequest) {
        LOGGER.debug("Start execution of SQL query getMoviesSearch");
        List<Movie> moviesSearch = jdbcTemplate.query(getGeneratedQuery.getMoviesSearchRequestSQL(movieSearchRequest), movieRowMapper);
        LOGGER.debug("Stop execution of SQL query getMoviesSearch");
        return moviesSearch;
    }

}








