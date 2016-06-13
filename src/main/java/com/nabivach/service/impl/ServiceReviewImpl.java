package com.nabivach.service.impl;

import com.nabivach.dao.ReviewDao;
import com.nabivach.dao.impl.ReviewDaoImpl;
import com.nabivach.entity.Review;
import com.nabivach.service.ServiceReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by grey3 on 08.06.2016.
 */

@Service
public class ServiceReviewImpl implements ServiceReview {

    @Autowired
    private ReviewDao reviewDao;
    public List<Review> getReviewForMovies(int movieId) {
        return reviewDao.getReviewForMovie(movieId);
    }
}
