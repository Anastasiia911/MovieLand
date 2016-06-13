package com.nabivach.dao.impl;

import com.nabivach.dao.MovieDao;
import com.nabivach.dao.ReviewDao;
import com.nabivach.dao.jdbc.mapper.*;
import com.nabivach.entity.Genre;
import com.nabivach.entity.Movie;
import com.nabivach.entity.Review;
import com.nabivach.service.ServiceMovie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by grey3 on 08.06.2016.
 */

@Repository //Mark as SPRING bean

public class ReviewDaoImpl implements ReviewDao {
    // String sql = "SELECT m.name, m.release_year, m.rating, g.name  FROM MOVIE m join movie_ganre mg on m.id = mg.movie_id  join genre g on mg.genre_id = g.id;";
    private final static Logger LOGGER = LoggerFactory.getLogger(ReviewDaoImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private String getReviewForMovieSQL;
    private ReviewRowMapper reviewRowMapper = new ReviewRowMapper();

    public List<Review> getReviewForMovie(int movieId) {
        //System.out.println(getAllMoviesSQL);

        LOGGER.debug("Starting execution SQL query...");
        long startTime = System.currentTimeMillis();

        List<Review> reviews = jdbcTemplate.query(getReviewForMovieSQL, new Object[]{movieId,2}, reviewRowMapper);

        long time = System.currentTimeMillis() - startTime;
        LOGGER.info("Result getReviewForMovie was received. It took {} ms", time);
        LOGGER.debug("Finish execution ...");
        return reviews;
    }

}








