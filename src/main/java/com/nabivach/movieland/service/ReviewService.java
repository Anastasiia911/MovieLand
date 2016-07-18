package com.nabivach.movieland.service;

import com.nabivach.movieland.dto.MovieByIdRequest;
import com.nabivach.movieland.entity.Review;

import java.util.List;

//SERVICE LAYER is there to provide logic to operate on the data sent to and from the DAO

public interface ReviewService {
    List<Review> getReviewForMovies(MovieByIdRequest movieByIdRequest);

}
