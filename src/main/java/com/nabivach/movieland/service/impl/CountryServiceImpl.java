package com.nabivach.movieland.service.impl;

import com.nabivach.movieland.dao.CountryDao;
import com.nabivach.movieland.entity.Country;
import com.nabivach.movieland.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryDao countryDao;

    public List<Country> getCountryForMovies(int movieId) {
        return countryDao.getCountryForMovie(movieId);
    }
}
