package com.nabivach.movieland.dao.impl;

import com.nabivach.movieland.dao.GenreDao;
import com.nabivach.movieland.entity.Genre;
import com.nabivach.movieland.dao.jdbc.mapper.GenreRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //Mark as SPRING bean

public class GenreDaoImpl implements GenreDao {

    private final static Logger LOGGER = LoggerFactory.getLogger(GenreDaoImpl.class);
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private String getGenresForMovieSQL;

    private GenreRowMapper genreRowMapper = new GenreRowMapper();

    public List<Genre> getGenreForMovie(int movieId) {

        LOGGER.debug("Starting execution SQL query...");
        long startTime = System.currentTimeMillis();

        List<Genre> genreList = jdbcTemplate.query(getGenresForMovieSQL, new Object[]{movieId}, genreRowMapper);

        long time = System.currentTimeMillis() - startTime;
        LOGGER.info("Result getGenres was received. It took {} ms", time);
        LOGGER.debug("Finish execution ...");

        return genreList;
    }

}







