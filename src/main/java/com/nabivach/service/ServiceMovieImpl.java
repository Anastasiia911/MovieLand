package com.nabivach.service;

import com.nabivach.dao.JdbcMovieDaoImpl;
import com.nabivach.dao.MovieDao;
import com.sun.org.apache.xpath.internal.SourceTree;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by grey3 on 08.06.2016.
 */
public class ServiceMovieImpl implements ServiceMovie {
     private JdbcMovieDaoImpl movieDao = new JdbcMovieDaoImpl();

        public List<?> getAllMovies(){

        return movieDao.getAllMovies();
    }

}
