package com.nabivach.dao.jdbc.mapper;

import com.nabivach.entity.Country;
import org.junit.Test;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by grey3 on 14.06.2016.
 */
public class CountryRowMapperTest {
    @Test
    public void mapRow() throws Exception {
        //Prepare
        ResultSet resultSet = mock(ResultSet.class);
        when (resultSet.getInt("id")).thenReturn(1);
        when (resultSet.getString("name")).thenReturn("USA");
        //Execute
        CountryRowMapper mapper = new CountryRowMapper();
        Country country = mapper.mapRow(resultSet,1);
        //Compare
        assertEquals(country.getId(), 1);
        assertEquals(country.getName(),"USA");
    }

}