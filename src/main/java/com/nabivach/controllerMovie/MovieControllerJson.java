package com.nabivach.controllerMovie;
import com.nabivach.service.ServiceMovieImpl;
import com.nabivach.util.ConvertJSONImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import java.util.List;

/**
 * Created by grey3 on 08.06.2016.
 */
public class MovieControllerJson {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ServiceMovieImpl movieService;

    @Autowired
    private ConvertJSONImpl convertJSONImpl;

//    @org.springframework.stereotype.Controller
    @RequestMapping(name ="/v1/movie", method = RequestMethod.GET)
    @ResponseBody

   public String getMovieListInJSON(@PathVariable String name) {

        List<?> MovieList= movieService.getAllMovies();
        String MovieListInJson = convertJSONImpl.JsonConverter();

      movieService.getAllMovies();

               return MovieListInJson;

    }

}
