package com.nabivach.movieland.dao.jdbc;

import com.nabivach.movieland.dao.MovieDao;
import com.nabivach.movieland.dao.jdbc.mapper.MovieRowMapper;
import com.nabivach.movieland.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository //Mark as SPRING bean

public class MovieDaoImpl implements MovieDao {
    // String sql = "SELECT m.name, m.release_year, m.rating, g.name  FROM MOVIE m join movie_ganre mg on m.id = mg.movie_id  join genre g on mg.genre_id = g.id;";
    private final static Logger LOGGER = LoggerFactory.getLogger(MovieDaoImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private String getAllMoviesSQL;

    @Autowired
    private String getMovieByIdSQL;

    private MovieRowMapper movieRowMapper = new MovieRowMapper();

    public List<Movie> getAllMovies() {
        LOGGER.debug("Starting execution SQL query...");
        long startTime = System.currentTimeMillis();

        List<Movie> allMovies = jdbcTemplate.query(getAllMoviesSQL, movieRowMapper);

        long time = System.currentTimeMillis() - startTime;
        LOGGER.info("Result AllMovies was received. It took {} ms", time);
        LOGGER.debug("Finish execution ...");

        return allMovies;
    }

    public Movie getMovieById() {
        LOGGER.debug("Starting execution SQL query...");
        long startTime = System.currentTimeMillis();
        Movie movie = jdbcTemplate.queryForObject(getMovieByIdSQL, movieRowMapper);
        long time = System.currentTimeMillis() - startTime;
        LOGGER.info("Result AllMovies was received. It took {} ms", time);
        return movie;
    }
}








