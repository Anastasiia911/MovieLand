package com.nabivach.movieland.service.impl;

import com.nabivach.movieland.dao.GenreDao;
import com.nabivach.movieland.entity.Genre;
import com.nabivach.movieland.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("genericGenreService")
public class GenericGenreService implements GenreService {

    @Autowired
    private GenreDao genreDao;

    public List<Genre> getGenresForMovie(int movieId) {

        return genreDao.getGenreForMovie(movieId);
    }

    public List<Genre> getGenresForAllMovies() {

        return genreDao.getGenresForAllMovies();
    }


}


