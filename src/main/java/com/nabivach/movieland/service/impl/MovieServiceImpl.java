package com.nabivach.movieland.service.impl;

import com.nabivach.movieland.dao.MovieDao;
import com.nabivach.movieland.dto.MovieByIdDto;
import com.nabivach.movieland.dto.MoviePreviewDto;
import com.nabivach.movieland.entity.Movie;
import com.nabivach.movieland.service.GenreService;
import com.nabivach.movieland.service.CountryService;
import com.nabivach.movieland.service.MovieService;
import com.nabivach.movieland.service.ReviewService;
import com.nabivach.movieland.transformer.TransformerEntityToDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
     @Autowired
     TransformerEntityToDto transformerEntityToDto;

    public List<MoviePreviewDto> getAllMovies() {
        List<MoviePreviewDto> movies = transformerEntityToDto.enrichMoviePreviewDto();
        return movies;
    }

    public MovieByIdDto getMovieById() {
        MovieByIdDto movie = transformerEntityToDto.enrichMovieByIdDto();
        return movie;
    }


}
