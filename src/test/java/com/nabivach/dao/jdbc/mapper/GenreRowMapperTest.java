package com.nabivach.dao.jdbc.mapper;

import com.nabivach.entity.Genre;
import com.nabivach.entity.Movie;
import org.junit.Test;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.Calendar;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by grey3 on 14.06.2016.
 */
public class GenreRowMapperTest {
    @Test
    public void mapRow() throws Exception {
//PREPARE
        ResultSet resultSet = mock(ResultSet.class);
        when (resultSet.getInt("id")).thenReturn(1);
        when (resultSet.getString("name")).thenReturn("драма");
        //EXECUTE
        GenreRowMapper mapper = new GenreRowMapper();
        Genre genre=mapper.mapRow(resultSet,1);
        //COMPARE
        assertEquals(genre.getId(),1);
        assertEquals(genre.getName(),"драма");
    }

}