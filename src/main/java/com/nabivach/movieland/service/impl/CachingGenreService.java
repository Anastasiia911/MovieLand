package com.nabivach.movieland.service.impl;

import com.nabivach.movieland.dao.GenreDao;
import com.nabivach.movieland.dto.MovieByIdRequest;
import com.nabivach.movieland.entity.Genre;
import com.nabivach.movieland.service.GenreService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@Service
public class CachingGenreService implements GenreService {
   private static final Logger LOGGER = LoggerFactory.getLogger(CachingGenreService.class);

    @Autowired
    private GenreDao genreDao;
    
    private Map<Integer, List<Genre>> movieIdGenresCache = new ConcurrentHashMap<>();

        @Override
    public List<Genre> getGenresForMovie(MovieByIdRequest movieByIdRequest) {
        LOGGER.debug("Start getting cache by movieId..");
        return movieIdGenresCache.get(movieByIdRequest.getMovieId());
    }

    @Scheduled(fixedRate = 4 * 60 * 60 * 1000)
    private void invalidateCache() {
        LOGGER.debug("Start clearing cache older then 4 hours ..");
        movieIdGenresCache.clear();
        LOGGER.debug("Start getting new cache ..");
        movieIdGenresCache = genreDao.getGenresForAllMovies();
        LOGGER.debug("Finish getting new cache ..");
    }
}


