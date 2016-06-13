package com.nabivach.service;

import com.nabivach.dao.impl.MovieDaoImpl;
import com.nabivach.entity.Movie;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by grey3 on 08.06.2016.
 */

@Component

public class ServiceMovieImpl implements ServiceMovie {
     private MovieDaoImpl movieDao = new MovieDaoImpl();

        public List<Movie> getAllMovies(){

        return  movieDao.getAllMovies();
    }

}
