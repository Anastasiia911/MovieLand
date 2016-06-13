package com.nabivach.dao.impl;

import com.nabivach.dao.CountryDao;
import com.nabivach.dao.MovieDao;
import com.nabivach.dao.jdbc.mapper.*;
import com.nabivach.entity.Country;
import com.nabivach.entity.Movie;
import com.nabivach.service.ServiceMovie;
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
public class CountryDaoImpl implements CountryDao {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    String getCountryForMovieSQL;

    public List<Country> getCountryForMovie() {

        //System.out.println(getAllMoviesSQL);
        final Logger LOGGER = LoggerFactory.getLogger(ServiceMovie.class);
        LOGGER.debug("Starting execution SQL query...");
        long startTime =System.currentTimeMillis();

        List <Country> countryList = jdbcTemplate.query(getCountryForMovieSQL, new CountryRowMapper());

        long time = System.currentTimeMillis() - startTime;
        LOGGER.info("Result getCountryForMovie was received. It took {} ms", time);
        LOGGER.debug("Finish execution ...");
        return countryList;
    }
}








