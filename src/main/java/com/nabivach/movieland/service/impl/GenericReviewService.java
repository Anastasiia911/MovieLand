package com.nabivach.movieland.service.impl;

import com.nabivach.movieland.dao.ReviewDao;
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

       public List<Review> getReviewForMovies(int movieId) {
        return reviewDao.getReviewForMovie(movieId);
    }

    public void addReview(ReviewRequest reviewRequest){
        reviewDao.addReview(reviewRequest);

    }
}
