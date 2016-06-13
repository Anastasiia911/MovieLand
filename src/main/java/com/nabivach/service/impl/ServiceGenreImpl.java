package com.nabivach.service.impl;

import com.nabivach.dao.GenreDao;
import com.nabivach.dao.impl.GenreDaoImpl;
import com.nabivach.entity.Genre;
import com.nabivach.service.ServiceGenre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by grey3 on 08.06.2016.
 */

@Service

public class ServiceGenreImpl implements ServiceGenre {

    @Autowired
    private GenreDao genreDao;

    public List<Genre> getGenresForMovies(int movieId) {
        return genreDao.getGenreForMovie(movieId);
    }
}


