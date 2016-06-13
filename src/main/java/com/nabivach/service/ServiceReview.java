package com.nabivach.service;

import com.nabivach.entity.Movie;
import com.nabivach.entity.Review;

import java.util.List;

/**
 * Created by grey3 on 08.06.2016.
 */

//SERVICE LAYER is there to provide logic to operate on the data sent to and from the DAO


public interface ServiceReview {
    List<Review> getReviewForMovies(int movieId);

}
