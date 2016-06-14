package com.nabivach.movieland.dao;

import com.nabivach.movieland.entity.Country;

import java.util.List;

//DAO as light as possible and exists to provide a connection to the DB

public interface CountryDao {
    List<Country> getCountryForMovie(int movieId);
}
