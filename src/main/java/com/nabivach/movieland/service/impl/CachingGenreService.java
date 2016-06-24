package com.nabivach.movieland.service.impl;

import com.nabivach.movieland.dao.GenreDao;
import com.nabivach.movieland.entity.Genre;
import com.nabivach.movieland.service.GenreService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@Service
public class CachingGenreService implements GenreService {
    @Autowired
    private GenreDao genreDao;
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(CachingGenreService.class);
    Map<Integer, List<Genre>> cacheGenresForAllMoviesMap = new ConcurrentHashMap<>();


    @Override
    public List<Genre> getGenresForMovie(int movieId) {
        LOGGER.debug("Start getting cache by movieId..");
        return genreDao.getGenreForMovie(movieId);
    }

    public Map<Integer, List<Genre>> getGenresForAllMovies() {
        LOGGER.debug("Start getting new cache ..");
        cacheGenresForAllMoviesMap = genreDao.getGenresForAllMovies();
        LOGGER.debug("Finish getting new cache ..");
        return cacheGenresForAllMoviesMap;
    }

    @Scheduled(fixedRate = 4 * 60 * 60 * 1000)
    public Map<Integer, List<Genre>> invalidateCache() {
        LOGGER.debug("Start clearing cache older then 4 hours ..");
        cacheGenresForAllMoviesMap.clear();
        cacheGenresForAllMoviesMap = getGenresForAllMovies();
        return cacheGenresForAllMoviesMap;
    }
}


