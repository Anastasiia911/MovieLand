package com.nabivach.movieland.dto.transformer;

import com.nabivach.movieland.dto.MovieDto;
import com.nabivach.movieland.entity.Movie;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service("movieDtoTransformer")
public class MovieDtoTransformer implements Transformer<Movie, MovieDto> {

    public MovieDto transformToDto(Movie movie) {
        MovieDto movieDto = new MovieDto();
        movieDto.setName(movie.getName());
        movieDto.setOriginalName(movie.getOriginalName());
        movieDto.setReleaseYear(movie.getReleaseYear());
        movieDto.setCountry(movie.getCountry());
        movieDto.setGenre(movie.getGenre());
        movieDto.setDescription(movie.getDescription());
        movieDto.setRating(movie.getRating());
        movieDto.setPrice(movie.getPrice());
        movieDto.setReview(movie.getReview());
        return movieDto;
    }
}
