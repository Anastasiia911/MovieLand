package com.nabivach.movieland.dto.transformer;

import com.nabivach.movieland.dto.MoviePreviewDto;
import com.nabivach.movieland.entity.Movie;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service("moviePreviewDtoTransformer")
public class MoviePreviewDtoTransformer implements Transformer<Movie, MoviePreviewDto> {

    public MoviePreviewDto transformToDto(Movie movie) {
        MoviePreviewDto moviePreviewDto = new MoviePreviewDto();
        moviePreviewDto.setName(movie.getName());
        moviePreviewDto.setOriginalName(movie.getOriginalName());
        moviePreviewDto.setReleaseYear(movie.getReleaseYear());
        moviePreviewDto.setGenre(movie.getGenre());
        moviePreviewDto.setRating(movie.getRating());
        return moviePreviewDto;
    }
}
