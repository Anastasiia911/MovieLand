package com.nabivach.dao;

import com.nabivach.myentity.Movie;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by anabivach on 09/06/2016.
 */
public class MovieRowMapper implements RowMapper<Movie> {

      public Movie mapRow(ResultSet rs, int i) throws SQLException {

            Movie moviepreview = new Movie();
            moviepreview.setName(rs.getString("NAME"));
            moviepreview.setName(rs.getString("RELEASE_YEAR"));
            moviepreview.setName(rs.getString("RATING"));
            moviepreview.setName(rs.getString("GENRE"));


        return moviepreview;
    }
}
