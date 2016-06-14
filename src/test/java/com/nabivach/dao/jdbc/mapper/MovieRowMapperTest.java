package com.nabivach.dao.jdbc.mapper;
import com.nabivach.dao.jdbc.mapper.MovieRowMapper;
import com.nabivach.entity.Movie;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.ResultSet;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class MovieRowMapperTest {

    @Test
    public void mapRow() throws Exception {

        //PREPARE
        ResultSet resultSet = mock(ResultSet.class);
        when(resultSet.getString("name")).thenReturn("Зеленая миля");
        when(resultSet.getString("original_name")).thenReturn("The Green Mile");
        when(resultSet.getInt("release_year")).thenReturn(1999);
        when(resultSet.getDouble("rating")).thenReturn(8.9);
        when(resultSet.next()).thenReturn(true).thenReturn(false);

        //EXECUTE
        MovieRowMapper mapper = new MovieRowMapper();
        Movie movie = mapper.mapRow(resultSet,1);

         //COMPARE
         assertEquals(movie.getName(),"Зеленая миля");
         assertEquals(movie.getOriginal_name(),"The Green Mile");
         assertEquals(movie.getRelease_year(),1999);
         assertEquals(movie.getRating(), 8.9,0);
         //assertEquals(movie.getGenre(), Arrays.asList("Comedy","Action"));
         //assertEquals(movie.getCountry(), Arrays.asList("USA"));

        }}