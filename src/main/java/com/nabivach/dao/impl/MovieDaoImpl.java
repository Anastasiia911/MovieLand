package com.nabivach.dao.impl;

import com.nabivach.dao.MovieDao;
import com.nabivach.dao.jdbc.mapper.*;
import com.nabivach.entity.Movie;
import com.nabivach.service.ServiceMovie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by grey3 on 08.06.2016.
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Repository //Mark as SPRING bean

public class MovieDaoImpl implements MovieDao {
   // String sql = "SELECT m.name, m.release_year, m.rating, g.name  FROM MOVIE m join movie_ganre mg on m.id = mg.movie_id  join genre g on mg.genre_id = g.id;";

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    String getAllMoviesSQL;


    public List<Movie> getAllMovies()
    {
        //System.out.println(getAllMoviesSQL);
        final Logger LOGGER = LoggerFactory.getLogger(ServiceMovie.class);
        LOGGER.debug("Starting execution SQL query...");
        long startTime =System.currentTimeMillis();

        List <Movie> allMovies = jdbcTemplate.query(getAllMoviesSQL, new MovieRowMapper());

        long time = System.currentTimeMillis() - startTime;
        LOGGER.info("Result AllMovies was received. It took {} ms", time);
        LOGGER.debug("Finish execution ...");

        return allMovies;
    }
}








