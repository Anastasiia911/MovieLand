package com.nabivach.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.nabivach.myentity.Movie;
import com.nabivach.service.ServiceMovie;
import com.nabivach.service.ServiceMovieImpl;

import java.io.FileOutputStream;

/**
 * Created by anabivach on 08/06/2016.
 */

public class ConvertJSONImpl implements ConvertJSON {

     ServiceMovie servicemovie = new ServiceMovieImpl();

     public String  JsonConverter()  {

         //Object to JSON STRING
         Gson gson = new Gson();
         String jsonString = gson.toJson(servicemovie.getAllMovies());
         System.out.println("json " + jsonString);

      return jsonString ;

    }

    }
