package com.nabivach.movieland.dao.jdbc.mapper;

import com.nabivach.movieland.entity.Country;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CountryRowMapper implements RowMapper<Country> {

    public Country mapRow(ResultSet rs, int i) throws SQLException {
        Country country = new Country();
        country.setId(rs.getInt("id"));
        country.setName(rs.getString("name"));
        return country;
    }
}
