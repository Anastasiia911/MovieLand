package com.nabivach.movieland.service.impl;
import com.nabivach.movieland.dto.ReviewDeletionRequest;
import com.nabivach.movieland.dto.ReviewRequest;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
public class PerformanceLoggingReviewService {

private static final Logger LOGGER = LoggerFactory.getLogger(PerformanceLoggingReviewService.class);

    @Autowired
    private GenericReviewService genericReviewService;

    public void addReviewForMovie(ReviewRequest reviewRequest) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        genericReviewService.addReview(reviewRequest);
        stopWatch.stop();
        LOGGER.debug("Finishing adding review it took {} ms", stopWatch.getTotalTimeMillis());
    }

    public void deleteReview(ReviewDeletionRequest reviewDeletionRequest){
       genericReviewService.deleteReview(reviewDeletionRequest);
    }
}
