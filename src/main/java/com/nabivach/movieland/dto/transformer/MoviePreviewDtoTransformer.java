package com.nabivach.movieland.dto.transformer;

import com.nabivach.movieland.dto.MoviePreviewDto;
import com.nabivach.movieland.entity.Movie;
import com.nabivach.movieland.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("moviePreviewDtoTransformer")
public class MoviePreviewDtoTransformer implements Transformer<Movie, MoviePreviewDto> {

    @Autowired
    private GenreService genreService;

    public void setGenreService(GenreService genreService) {
        this.genreService = genreService;
    }

    public MoviePreviewDto transformToDto(Movie movie) {
        MoviePreviewDto moviePreviewDto = new MoviePreviewDto();
        moviePreviewDto.setName(movie.getName());
        moviePreviewDto.setOriginalName(movie.getOriginalName());
        moviePreviewDto.setReleaseYear(movie.getReleaseYear());
        // TO DO INSTEAD OF genreService.getGenresForMovie TAKE FROM HASH MAP
        moviePreviewDto.setGenre(genreService.getGenresForMovie(movie.getId()));
        moviePreviewDto.setRating(movie.getRating());
        return moviePreviewDto;
    }
}
