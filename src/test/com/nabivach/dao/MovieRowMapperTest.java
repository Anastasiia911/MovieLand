package com.nabivach.dao;
import com.nabivach.myentity.Movie;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.ResultSet;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * Created by grey3 on 10.06.2016.
 */
public class MovieRowMapperTest {

    @Autowired
    private MovieRowMapper movieRowMapper;

    @Autowired
    private Movie realmovie;

    @Test
    public void mapRow() throws Exception {
        //PREPARE
        ResultSet resultSet = mock(ResultSet.class);
        Mockito.when(resultSet.getString("NAME")).thenReturn("Зеленая миля");
        Mockito.when(resultSet.getString("RELEASE_YEAR")).thenReturn("1999");
        Mockito.when(resultSet.getString("RATING")).thenReturn("8.9");
        Mockito.when(resultSet.getString("GENRE")).thenReturn("фэнтези, драма, криминал, детектив");
        Mockito.when(resultSet.next()).thenReturn(true).thenReturn(false);

         //EXECUTE
         Movie realMovie = movieRowMapper.mapRow(resultSet,0);
         //String result = realMovie.toString();

         //COMPARE
         assertEquals(realMovie.getName(), "Зеленая миля");
         assertEquals(realMovie.getRelease_year(), "1999");
         assertEquals(realMovie.getRating(), "8.9");
         assertEquals(realMovie.getGenre(), "фэнтези, драма, криминал, детектив");

           }

}