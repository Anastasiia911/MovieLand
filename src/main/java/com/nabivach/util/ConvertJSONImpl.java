package com.nabivach.util;

import com.google.gson.Gson;
import com.nabivach.entity.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by anabivach on 08/06/2016.
 */
@Service
public class ConvertJSONImpl implements ConvertJson {

    public String movieToJsonConverter(Movie movie) {

        //Object to JSON STRING
        Gson gson = new Gson();
        String jsonString = gson.toJson(movie);
        //System.out.println("json " + jsonString);

        return jsonString;

    }

    public String movieToJsonConverter(List<Movie> movies) {
        StringBuilder moviesJson = new StringBuilder();
        for (Movie movie : movies) {
            moviesJson.append(movieToJsonConverter(movie));
        }

        return moviesJson.toString();
    }

}
