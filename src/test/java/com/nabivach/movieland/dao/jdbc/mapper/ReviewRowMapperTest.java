package com.nabivach.movieland.dao.jdbc.mapper;

import com.nabivach.movieland.entity.Review;
import org.junit.Test;

import java.sql.ResultSet;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ReviewRowMapperTest {
    @Test
    public void mapRow() throws Exception {
        //Prepare
        ResultSet resultSet = mock(ResultSet.class);
        when(resultSet.getInt("id")).thenReturn(1);
        when(resultSet.getString("description")).thenReturn("Description");
        //Execute
        ReviewRowMapper mapper = new ReviewRowMapper();
        Review review = mapper.mapRow(resultSet, 1);
        //Compare
        assertEquals(review.getId(), 1);
        assertEquals(review.getDescription(), "Description");
    }

}