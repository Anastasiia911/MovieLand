package com.nabivach.movieland.dao.jdbc;

import com.nabivach.movieland.dao.CountryDao;
import com.nabivach.movieland.dao.jdbc.mapper.CountryRowMapper;
import com.nabivach.movieland.entity.Country;
import com.nabivach.movieland.service.ServiceMovie;
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
public class JdbcCountryDao implements CountryDao {
    private final static Logger LOGGER = LoggerFactory.getLogger(ServiceMovie.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private String getCountryForMovieSQL;

    CountryRowMapper countryRowMapper = new CountryRowMapper();

    public List<Country> getCountryForMovie(int movieId) {

        //System.out.println(getAllMoviesSQL);

        LOGGER.debug("Starting execution SQL query...");
        long startTime = System.currentTimeMillis();

        List<Country> countryList = jdbcTemplate.query(getCountryForMovieSQL, new Object[]{movieId}, countryRowMapper);

        long time = System.currentTimeMillis() - startTime;
        LOGGER.info("Result getCountryForMovie was received. It took {} ms", time);
        return countryList;
    }
}








