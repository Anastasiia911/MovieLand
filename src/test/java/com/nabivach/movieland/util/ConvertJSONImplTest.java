package com.nabivach.movieland.util;

import com.nabivach.movieland.entity.Genre;
import com.nabivach.movieland.entity.Movie;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ConvertJSONImplTest {
    @Test
    public void movieToJsonConverter() throws Exception {
        String expectedJson = "{\"id\":0,\"name\":\"Movie\",\"original_name\":\"originalName\",\"release_year\":2000,\"genre\":[{\"id\":1,\"name\":\"Drama\"},{\"id\":2,\"name\":\"Criminal\"}],\"rating\":8.6,\"price\":0.0}";
        ConvertJSONImpl convertJSON = new ConvertJSONImpl();
        Movie movie = new Movie();
        movie.setOriginal_name("originalName");
        movie.setName("Movie");
        movie.setRelease_year(2000);
        movie.setRating(8.6);
        Genre genre1 = new Genre();
        genre1.setId(1);
        genre1.setName("Drama");
        Genre genre2 = new Genre();
        genre2.setId(2);
        genre2.setName("Criminal");
        List<Genre> genres = new ArrayList<Genre>();
        genres.add(genre1);
        genres.add(genre2);
        movie.setGenre(genres);

        String actualJson = convertJSON.movieToJsonConverter(movie);
        assertEquals(actualJson, expectedJson);

    }

}