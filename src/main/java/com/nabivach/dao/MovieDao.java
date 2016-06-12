package com.nabivach.dao;

import com.nabivach.myentity.Movie;

import java.util.List;

/**
 * Created by grey3 on 08.06.2016.
 */

//DAO as light as possible and exists to provide a connection to the DB

public interface MovieDao {
    List<Movie> getAllMovies();
}
