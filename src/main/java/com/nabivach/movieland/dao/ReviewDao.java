package com.nabivach.movieland.dao;

import com.nabivach.movieland.entity.Review;

import java.util.List;


//DAO as light as possible and exists to provide a connection to the DB

public interface ReviewDao {
    List<Review> getReviewForMovie(int movieId);
}
