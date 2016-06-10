package com.nabivach.dao;

import com.nabivach.myentity.Movie;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

import static java.sql.DriverManager.*;

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


    public List<?> getAllMovies()
    {
       List <Movie> allMovies = jdbcTemplate.query(getAllMoviesSQL, new MovieRowMapper());
        return allMovies;
    }
}








