package com.nabivach.dao.jdbc.mapper;

import com.nabivach.dao.GenreDao;
import com.nabivach.entity.Movie;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by anabivach on 09/06/2016.
 */

@Service
public class MovieRowMapper implements RowMapper<Movie> {

    public Movie mapRow(ResultSet rs, int i) throws SQLException {

        Movie movie = new Movie();
        movie.setName(rs.getString("name"));
        movie.setOriginal_name(rs.getString("original_name"));
        movie.setRelease_year(rs.getInt("release_year"));
        movie.setRating(rs.getDouble("rating"));


        return movie;
    }
}
