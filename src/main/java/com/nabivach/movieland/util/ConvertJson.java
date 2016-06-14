package com.nabivach.movieland.util;

import com.nabivach.movieland.entity.Movie;

import java.util.List;

public interface ConvertJson {

    String movieToJsonConverter(Movie movie);

    String movieToJsonConverter(List<Movie> movies);
}



