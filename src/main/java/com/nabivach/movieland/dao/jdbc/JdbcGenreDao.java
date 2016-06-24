package com.nabivach.movieland.dao.jdbc;

import com.nabivach.movieland.dao.GenreDao;
import com.nabivach.movieland.dao.jdbc.mapper.GenreRowMapper;
import com.nabivach.movieland.dto.MovieRequest;
import com.nabivach.movieland.entity.Genre;
import com.nabivach.movieland.entity.Movie;
import com.nabivach.movieland.util.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository //Mark as SPRING bean

public class JdbcGenreDao implements GenreDao {

    private final static Logger LOGGER = LoggerFactory.getLogger(JdbcGenreDao.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private String getGenresForMovieSQL;

    @Autowired
    private JdbcMovieDao jdbcMovieDao;

    @Autowired
    private String getGenresForAllMoviesSQL;
    private GenreRowMapper genreRowMapper = new GenreRowMapper();

    public List<Genre> getGenreForMovie(int movieId) {
        LOGGER.debug("Starting execution SQL query...");
        long startTime = System.currentTimeMillis();

        List<Genre> genreList = jdbcTemplate.query(getGenresForMovieSQL, new Object[]{movieId}, genreRowMapper);

        long time = System.currentTimeMillis() - startTime;
        LOGGER.info("Result getGenres was received. It took {} ms", time);
        return genreList;
    }

    @Override
    public Map<Integer, List<Genre>> getGenresForAllMovies() {
        LOGGER.debug("Starting execution SQL query for getting GenresForAllMovies ...");
        MovieRequest movieRequest = new MovieRequest();
        movieRequest.setPrice(Order.ASC);
        movieRequest.setRating(Order.ASC);
        LOGGER.debug("Starting execution SQL query for getting AllMovies ...");
        List<Movie> allMovies = jdbcMovieDao.getAllMovies(movieRequest);
        LOGGER.debug("Getting AllMovies finished successfully..");
        Map<Integer, List<Genre>> genresForAllMoviesMap = new ConcurrentHashMap<>();
        for (int i = 0; i < allMovies.size(); i++) {
            Movie movie = allMovies.get(i);
            genresForAllMoviesMap.put(movie.getId(), getGenreForMovie(movie.getId()));
        }
        LOGGER.debug("Result getGenresForAllMovies was received");
        return genresForAllMoviesMap;
    }
}








