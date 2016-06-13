package src.com.nabivach.dao;

import com.nabivach.dao.MovieDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by anastasiia_911 on 6/12/16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/context.xml"})
public class MovieDaoImplTest {

    // BasicConfigurator.configure();
    @Autowired
    MovieDao movieDao;

    @Test
    public void testGetAllMovies() throws Exception {
        System.out.println(movieDao.getAllMovies());

    }
}