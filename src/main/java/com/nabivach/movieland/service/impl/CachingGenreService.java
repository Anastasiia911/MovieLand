package com.nabivach.movieland.service.impl;

import com.nabivach.cache.CacheContainer;
import com.nabivach.cache.PostConstruct;
import com.nabivach.movieland.dao.jdbc.JdbcMovieDao;
import com.nabivach.movieland.dto.MovieRequest;
import com.nabivach.movieland.entity.Genre;
import com.nabivach.movieland.service.GenreService;
import com.nabivach.movieland.util.Order;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class CachingGenreService implements GenreService, ApplicationListener<ContextRefreshedEvent> {

    //private LocalDateTime refreshTime;
    public static final String CACHE_ID = "genre";
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(CachingGenreService.class);

    @Autowired
    @Qualifier("genericGenreService")
    private GenreService genreService;

    @Autowired
    private CacheContainer cacheContainer;

    @Autowired
    private JdbcMovieDao jdbcMovieDao;

    Map<String, Object> cache = cacheContainer.getCache(CACHE_ID);

    @PostConstruct
    @Override
    public synchronized List<Genre> getGenresForMovie(int movieId) {
        LOGGER.debug("Starting getting genre cache..");
        String key = String.valueOf(movieId);
        if (!cache.containsKey(key)) {
            List<Genre> genres = genreService.getGenresForMovie(movieId);
            cache.put(key, genres);//cache is Map <movieId key,genres value >
        }
        return (List<Genre>) cache.get(key);
    }

    @Scheduled(fixedRate = 14400000)
    public void refresh(int movieId) {
        LOGGER.debug("Scheduled activity refresh cache every 4 hours  - starting getting genre cache..");

        cache.clear();
        getGenresForMovie(movieId);

    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        List<Integer> moviesIdList = jdbcMovieDao.getMoviesIdList();
        for (Integer movieId : moviesIdList) {
            getGenresForMovie(moviesIdList.get(movieId));
        }
    }
}


