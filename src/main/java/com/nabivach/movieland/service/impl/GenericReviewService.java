package com.nabivach.movieland.service.impl;

import com.nabivach.movieland.dao.ReviewDao;
import com.nabivach.movieland.dto.MovieByIdRequest;
import com.nabivach.movieland.dto.ReviewDeletionRequest;
import com.nabivach.movieland.dto.ReviewRequest;
import com.nabivach.movieland.entity.Review;
import com.nabivach.movieland.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenericReviewService implements ReviewService {

    @Autowired
    private ReviewDao reviewDao;

    @Autowired
    private CachedSecurityService cachedSecurityService;

    public List<Review> getReviewForMovies(MovieByIdRequest movieByIdRequest) {
        return reviewDao.getReviewForMovie(movieByIdRequest.getMovieId());
    }

    public void addReview(ReviewRequest reviewRequest) {
        reviewDao.addReview(reviewRequest);
    }

    public void deleteReview(ReviewDeletionRequest reviewDeletionRequest) {
       int userId = cachedSecurityService.getUserIdByToken(reviewDeletionRequest.getAuthToken());
        if (reviewDao.checkIsReviewOwnedByUser(userId, reviewDeletionRequest)) {
            reviewDao.deleteReview(reviewDeletionRequest);
        }
    }
}