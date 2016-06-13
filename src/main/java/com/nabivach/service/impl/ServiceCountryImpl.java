package com.nabivach.service.impl;

import com.nabivach.dao.CountryDao;
import com.nabivach.dao.impl.MovieDaoImpl;
import com.nabivach.entity.Country;
import com.nabivach.entity.Movie;
import com.nabivach.service.ServiceCountry;
import com.nabivach.service.ServiceMovie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by grey3 on 08.06.2016.
 */

@Service
public class ServiceCountryImpl implements ServiceCountry {

    @Autowired
    private CountryDao countryDao;
    public List<Country> getCountryForMovies(int movieId) {
        return countryDao.getCountryForMovie(movieId);
    }
}
