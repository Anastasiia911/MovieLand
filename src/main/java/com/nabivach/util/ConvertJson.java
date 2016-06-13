package com.nabivach.util;

import com.nabivach.entity.Movie;

import java.util.List;

/**
 * Created by grey3 on 08.06.2016.
 */

public interface ConvertJson {

    String movieToJsonConverter(Movie movie);
    String movieToJsonConverter (List<Movie> movies);
}



