package com.nabivach.movieland.service.impl;

import com.nabivach.movieland.dao.ReviewDao;
import com.nabivach.movieland.entity.Review;
import com.nabivach.movieland.service.ServiceReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceReviewImpl implements ServiceReview {

    @Autowired
    private ReviewDao reviewDao;

    public List<Review> getReviewForMovies(int movieId) {
        return reviewDao.getReviewForMovie(movieId);
    }
}
