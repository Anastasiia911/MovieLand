package com.nabivach.movieland.util;

import com.nabivach.movieland.dto.MovieRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueryGenerator {

    @Autowired
    private String getAllMoviesSQL;

    public String getGeneratedQueryAllMovies(MovieRequest movieRequest) {
        return getAllMoviesSQL + " order by rating " + movieRequest.getRating() + ", price " + movieRequest.getPrice();
    }

    public String getGeneretaedQueryUserRequest(){
        return getAllMoviesSQL;
    }
}
