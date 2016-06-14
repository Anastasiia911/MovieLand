package com.nabivach.movieland.dao.jdbc.mapper;

import com.nabivach.movieland.entity.Genre;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GenreRowMapper implements RowMapper<Genre> {

    public Genre mapRow(ResultSet rs, int i) throws SQLException {

        Genre genre = new Genre();
        genre.setId(rs.getInt("id"));
        genre.setName(rs.getString("name"));
        return genre;

    }


}
