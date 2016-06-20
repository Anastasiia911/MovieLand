package com.nabivach.movieland.service.impl;

import com.nabivach.cache.CacheContainer;
import com.nabivach.movieland.entity.Genre;
import com.nabivach.movieland.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Map;

/**
 * Created by anabivach on 17/06/2016.
 */
public class CachingGenreService implements GenreService {

    public static final String CACHE_ID = "genre";

    @Autowired
    private CacheContainer cacheContainer;

    @Autowired
    @Qualifier("genericGenreService")
    private GenreService genreService;

    @Override
    public synchronized List<Genre> getGenresForMovie(int movieId) {
        Map<String, Object> cache = cacheContainer.getCache(CACHE_ID);
        String key = String.valueOf(movieId);
        if (!cache.containsKey(key)) {
            List<Genre> genres = genreService.getGenresForMovie(movieId);
            cache.put(key, genres);
        }
        return (List<Genre>) cache.get(key);
    }
}
