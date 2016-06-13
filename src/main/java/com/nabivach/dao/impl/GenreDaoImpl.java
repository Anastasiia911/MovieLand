package com.nabivach.dao.impl;

import com.nabivach.dao.GenreDao;
import com.nabivach.dao.MovieDao;
import com.nabivach.dao.jdbc.mapper.*;
import com.nabivach.entity.Genre;
import com.nabivach.entity.Movie;
import com.nabivach.service.ServiceMovie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by grey3 on 08.06.2016.
 */

@Repository //Mark as SPRING bean

public class GenreDaoImpl implements GenreDao {
    // String sql = "SELECT m.name, m.release_year, m.rating, g.name  FROM MOVIE m join movie_ganre mg on m.id = mg.movie_id  join genre g on mg.genre_id = g.id;";

    private final static Logger LOGGER = LoggerFactory.getLogger(GenreDaoImpl.class);
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private String getGenresForMovieSQL;

    private GenreRowMapper genreRowMapper = new GenreRowMapper();

    public List<Genre> getGenreForMovie(int movieId) {
        //System.out.println(getAllMoviesSQL);

        LOGGER.debug("Starting execution SQL query...");
        long startTime = System.currentTimeMillis();

        List<Genre> genreList = jdbcTemplate.query(getGenresForMovieSQL, new Object[]{movieId}, genreRowMapper);

        long time = System.currentTimeMillis() - startTime;
        LOGGER.info("Result getGenres was received. It took {} ms", time);
        LOGGER.debug("Finish execution ...");

        return genreList;
    }

}








