package com.nabivach.movieland.dto.transformer;

import com.nabivach.movieland.dto.MoviePreviewDto;
import com.nabivach.movieland.entity.Movie;
import com.nabivach.movieland.service.GenreService;
import com.nabivach.movieland.service.impl.CachingGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service("moviePreviewDtoTransformer")
public class MoviePreviewDtoTransformer implements Transformer<Movie, MoviePreviewDto> {

    @Qualifier("genericGenreService")
    @Autowired
    private GenreService genreService;

    @Autowired
    private CachingGenreService cachingGenreService;

    public void setGenreService(GenreService genreService) {
        this.genreService = genreService;
    }

    public MoviePreviewDto transformToDto(Movie movie) {
        MoviePreviewDto moviePreviewDto = new MoviePreviewDto();
        moviePreviewDto.setName(movie.getName());
        moviePreviewDto.setOriginalName(movie.getOriginalName());
        moviePreviewDto.setReleaseYear(movie.getReleaseYear());
        moviePreviewDto.setGenre(cachingGenreService.getGenresForMovie(movie.getId()));
        moviePreviewDto.setRating(movie.getRating());
        return moviePreviewDto;
    }
}
