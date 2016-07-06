package com.nabivach.movieland.dto.transformer;

import com.nabivach.movieland.dto.MovieRequest;
import com.nabivach.movieland.util.Order;
import org.springframework.stereotype.Service;

@Service("movieRequestTransformer")

public class MovieRequestTransformer {

    public MovieRequest getMovieRequest(String rating, String price, int pageNumber){
        MovieRequest movieRequest = new MovieRequest();
        movieRequest.setRating(Order.getOrderForParams(rating));
        movieRequest.setPrice(Order.getOrderForParams(price));
        movieRequest.setPageNumber(pageNumber);

    return movieRequest;
    }

}
