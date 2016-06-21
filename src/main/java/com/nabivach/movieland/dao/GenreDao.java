package com.nabivach.movieland.dao;

import com.nabivach.movieland.entity.Genre;

import java.util.List;


//DAO as light as possible and exists to provide a connection to the DB

public interface GenreDao {
    List<Genre> getGenreForMovie(int movieId);

    List<Genre> getGenresForAllMovies();


}
