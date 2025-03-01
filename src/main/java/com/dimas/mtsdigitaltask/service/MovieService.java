package com.dimas.mtsdigitaltask.service;

import com.dimas.mtsdigitaltask.model.dto.MovieDto;
import com.dimas.mtsdigitaltask.model.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MovieService {
    Long findLastEntryId();

    void saveAllMovies(List<Movie> movies);

    MovieDto findMovieByMovieDbId(Long movieDbId);

    Page<MovieDto> findAllMovies(Pageable pageable);
}
