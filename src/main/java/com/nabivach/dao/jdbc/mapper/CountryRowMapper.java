package com.nabivach.dao.jdbc.mapper;

import com.nabivach.entity.Country;
import com.nabivach.entity.Genre;
import com.nabivach.entity.Movie;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by anabivach on 09/06/2016.
 */
public class CountryRowMapper implements RowMapper<Country> {

      public Country mapRow(ResultSet rs, int i) throws SQLException {
          Country country = new Country();
          country.setId(rs.getInt("id"));
          country.setName(rs.getString("name"));
        return country ;
    }
}
