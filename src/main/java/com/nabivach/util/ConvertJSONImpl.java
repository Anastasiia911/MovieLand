package com.nabivach.util;

import com.google.gson.Gson;
import com.nabivach.service.ServiceMovie;
import com.nabivach.service.ServiceMovieImpl;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by anabivach on 08/06/2016.
 */
@Component
public class ConvertJSONImpl implements ConvertJson {

     ServiceMovie servicemovie = new ServiceMovieImpl();
    List<?> movieList = servicemovie.getAllMovies();

    public String ObjectToJsonConverter(Object object) {

        //Object to JSON STRING
        Gson gson = new Gson();
        String jsonString = gson.toJson(movieList);
        System.out.println("json " + jsonString);

        return jsonString ;
       // return null;
    }
}
