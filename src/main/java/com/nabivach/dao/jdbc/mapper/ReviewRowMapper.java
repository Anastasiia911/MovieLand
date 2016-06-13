package com.nabivach.dao.jdbc.mapper;

import com.nabivach.entity.Movie;
import com.nabivach.entity.Review;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by anabivach on 09/06/2016.
 */
public class ReviewRowMapper implements RowMapper<Review> {

      public Review mapRow(ResultSet rs, int i) throws SQLException {

          Review review = new Review();
          review.setId(rs.getInt("id"));
          review.setDescription(rs.getString("description"));

        return review;
    }
}
