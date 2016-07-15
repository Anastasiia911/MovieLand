package com.nabivach.movieland.controller;

import com.nabivach.movieland.dto.ReviewDeletionRequest;
import com.nabivach.movieland.dto.ReviewRequest;
import com.nabivach.movieland.service.impl.PerformanceLoggingReviewService;
import com.nabivach.movieland.util.deserializer.JsonReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller

@RequestMapping("/v1")

public class ReviewController {

    @Autowired
    private PerformanceLoggingReviewService performanceLoggingReviewService;

    @Autowired
    private JsonReader jsonReader;

    @Autowired
    private SecurityController securityController;

    private static final Logger LOGGER = LoggerFactory.getLogger(ReviewController.class);

    @RequestMapping(value = "/review", method = RequestMethod.POST)
    @ResponseBody
    public String addReviewForMovie(@RequestBody String json) throws IOException {
        LOGGER.debug("Receive request for adding movie review..");
        ReviewRequest reviewRequest = jsonReader.parseJson(json, ReviewRequest.class);
        performanceLoggingReviewService.addReviewForMovie(reviewRequest);
        LOGGER.debug("Movie review was added..");
        return json;
    }

    @RequestMapping(value = "/review", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteReviewForMovie(@RequestHeader(value = "user-token") String token, @RequestParam int reviewId) {
        LOGGER.debug("Receive request for deletion movie review number {}..", reviewId);
        ReviewDeletionRequest reviewDeletionRequest = new ReviewDeletionRequest();
        reviewDeletionRequest.setReviewId(reviewId);
        reviewDeletionRequest.setAuthToken(token);
        performanceLoggingReviewService.deleteReview(reviewDeletionRequest);
        LOGGER.debug("Movie review was deleted - review id {}..", reviewId);
        return " Review number " + reviewId + " was deleted...";
    }
}
