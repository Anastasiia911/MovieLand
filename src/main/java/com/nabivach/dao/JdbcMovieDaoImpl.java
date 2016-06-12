package com.nabivach.dao;

import com.nabivach.myentity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by grey3 on 08.06.2016.
 */

@Component //Mark as SPRING bean

public class JdbcMovieDaoImpl implements MovieDao {
   // String sql = "SELECT NAME, RELEASE_YEAR, RATING, GENRE FROM MOVIE";

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    String getAllMoviesSQL;


    public List<Movie> getAllMovies()
    {
        System.out.println(getAllMoviesSQL);
       List <Movie> allMovies = new ArrayList<Movie>(); //jdbcTemplate.query(getAllMoviesSQL, new MovieRowMapper());
        return allMovies;
    }
}








