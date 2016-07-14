package com.nabivach.movieland.dao;

import com.nabivach.movieland.dto.ReviewDeletionRequest;
import com.nabivach.movieland.dto.ReviewRequest;
import com.nabivach.movieland.entity.Review;

import java.util.List;


//DAO as light as possible and exists to provide a connection to the DB

public interface ReviewDao {
    List<Review> getReviewForMovie(int movieId);
    void addReview(ReviewRequest reviewRequest);
    void deleteReview(ReviewDeletionRequest reviewDeletionRequest);
    boolean checkIsReviewOwnedByUser(int userId, ReviewDeletionRequest reviewDeletionRequest);
}
