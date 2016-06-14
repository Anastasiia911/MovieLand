package com.nabivach.service.impl;

import com.nabivach.dao.MovieDao;
import com.nabivach.dao.impl.MovieDaoImpl;
import com.nabivach.entity.Movie;
import com.nabivach.service.ServiceMovie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by grey3 on 08.06.2016.
 */

@Service
public class ServiceMovieImpl implements ServiceMovie {

    @Autowired
     private MovieDao movieDao;

        public List<Movie> getAllMovies(){
            List<Movie> movies = movieDao.getAllMovies();
                               return movies;
    }



}
