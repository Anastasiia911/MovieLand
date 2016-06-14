package com.nabivach.movieland.service.impl;

import com.nabivach.movieland.dao.GenreDao;
import com.nabivach.movieland.entity.Genre;
import com.nabivach.movieland.service.ServiceGenre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ServiceGenreImpl implements ServiceGenre {

    @Autowired
    private GenreDao genreDao;

    public List<Genre> getGenresForMovies(int movieId) {
        return genreDao.getGenreForMovie(movieId);
    }
}


