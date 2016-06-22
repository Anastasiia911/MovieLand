package com.nabivach.movieland.dao.jdbc;

import com.nabivach.movieland.dao.MovieDao;
import com.nabivach.movieland.dao.jdbc.mapper.MovieRowMapper;
import com.nabivach.movieland.entity.Movie;
import com.nabivach.movieland.util.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository //Mark as SPRING bean

public class JdbcMovieDao implements MovieDao {
    // String sql = "SELECT m.name, m.release_year, m.rating, g.name  FROM MOVIE m join movie_ganre mg on m.id = mg.movie_id  join genre g on mg.genre_id = g.id;";
    private final static Logger LOGGER = LoggerFactory.getLogger(JdbcMovieDao.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private String getAllMoviesSQL;

    @Autowired
    private String getMovieByIdSQL;

    private MovieRowMapper movieRowMapper = new MovieRowMapper();

    public List<Movie> getAllMovies(Order rating, Order price) {
        LOGGER.debug("Starting execution SQL query...");
        long startTime = System.currentTimeMillis();

        List<Movie> allMovies = jdbcTemplate.query(getAllMoviesSQL + " order by rating " + rating.getSql() + ", price " + price.getSql(), movieRowMapper);

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

    public List<Integer> getMoviesIdList() {
        List<Integer> movieIdList = new ArrayList<>();
        for (Movie movie : getAllMovies(Order.ASCENDING, Order.ASCENDING)) {
            movieIdList.add(movie.getId());
        }
        return movieIdList;
    }
}








