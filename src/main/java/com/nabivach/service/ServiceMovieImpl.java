package com.nabivach.service;

import com.nabivach.dao.JdbcMovieDaoImpl;
import com.nabivach.myentity.Movie;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by grey3 on 08.06.2016.
 */

@Component

public class ServiceMovieImpl implements ServiceMovie {
     private JdbcMovieDaoImpl movieDao = new JdbcMovieDaoImpl();

        public List<Movie> getAllMovies(){

        return (List<Movie>) movieDao.getAllMovies();
    }

}
