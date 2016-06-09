package com.nabivach.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nabivach.myentity.Movie;

import java.io.FileOutputStream;

/**
 * Created by anabivach on 08/06/2016.
 */



public class ConvertJSONImpl implements ConvertJSON {


    private String addQuotes(Object value) {
        return "\"" + value + "\"";
    }

     public String  JsonConverter(Movie movie) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        //Object to JSON STRING
      String allMovies =  mapper.writeValueAsString(movie);
      return allMovies  ;

    }
}
