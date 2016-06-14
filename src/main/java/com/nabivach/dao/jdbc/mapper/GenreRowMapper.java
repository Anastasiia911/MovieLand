package com.nabivach.dao.jdbc.mapper;

import com.nabivach.entity.Genre;
import com.nabivach.entity.Movie;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by anabivach on 09/06/2016.
 */
public class GenreRowMapper implements RowMapper<Genre> {

    public Genre mapRow(ResultSet rs, int i) throws SQLException {

        Genre genre = new Genre();
        genre.setId(rs.getInt("id"));
        genre.setName(rs.getString("name"));
        return genre ;

    }


}
