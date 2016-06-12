package com.nabivach.controllerMovie;
import com.nabivach.myentity.Movie;
import com.nabivach.service.ServiceMovieImpl;
import com.nabivach.util.ConvertJSONImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by grey3 on 08.06.2016.
 */

@Controller
public class MovieControllerJson {

    @Autowired
    private ServiceMovieImpl ServiceMovieImpl;

    @Autowired
    private ConvertJSONImpl ConvertJson;

//    @org.springframework.stereotype.Controller
    @RequestMapping(name ="/v1/movie", method = RequestMethod.GET)
    @ResponseBody

   public String getMovieListInJSON(@PathVariable String name) {

        List<Movie> MovieList=  ServiceMovieImpl.getAllMovies();


               return ConvertJson.ObjectToJsonConverter(MovieList);

    }

}


