package com.nabivach.movieland.service.impl;

import com.nabivach.movieland.dao.GenreDao;
import com.nabivach.movieland.dto.MovieByIdRequest;
import com.nabivach.movieland.entity.Genre;
import com.nabivach.movieland.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("genericGenreService")
public class GenericGenreService implements GenreService {

    @Autowired
    private GenreDao genreDao;

    @Override
    public List<Genre> getGenresForMovie(MovieByIdRequest movieByIdRequest) {
        return genreDao.getGenreForMovie(movieByIdRequest.getMovieId());
    }
}


