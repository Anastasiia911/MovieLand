package com.nabivach.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by anastasiia_911 on 6/12/16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:context.xml"})
public class JdbcMovieDaoImplTest {

    @Test
    public void testGetAllMovies() throws Exception {

        JdbcMovieDaoImpl movieDao = new JdbcMovieDaoImpl();
        System.out.println(movieDao.getAllMovies());

    }
}