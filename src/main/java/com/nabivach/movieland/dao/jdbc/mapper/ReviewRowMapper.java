package com.nabivach.movieland.dao.jdbc.mapper;

import com.nabivach.movieland.entity.Review;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReviewRowMapper implements RowMapper<Review> {

    public Review mapRow(ResultSet rs, int i) throws SQLException {

        Review review = new Review();
        review.setId(rs.getInt("id"));
        review.setDescription(rs.getString("description"));

        return review;
    }
}
