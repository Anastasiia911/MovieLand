package com.nabivach.movieland.dto.transformer;

import com.nabivach.movieland.dto.MovieRequest;
import com.nabivach.movieland.util.Order;
import org.springframework.stereotype.Component;

@Component("movieRequestTransformer")

public class MovieRequestTransformer {

    public MovieRequest getMovieRequest(String rating, String price){
        MovieRequest movieRequest = new MovieRequest();
        movieRequest.setRating(Order.getOrderForParams(rating));
        movieRequest.setPrice(Order.getOrderForParams(price));

    return movieRequest;
    }

}
