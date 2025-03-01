package com.dimas.mtsdigitaltask.service.implementation;

import com.dimas.mtsdigitaltask.exception.MovieNotFoundException;
import com.dimas.mtsdigitaltask.mapper.MovieMapper;
import com.dimas.mtsdigitaltask.model.dto.MovieDto;
import com.dimas.mtsdigitaltask.model.entity.Movie;
import com.dimas.mtsdigitaltask.repository.MovieRepository;
import com.dimas.mtsdigitaltask.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MovieServiceImplementation implements MovieService {
    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    @Override
    public Long findLastEntryId() {
        var movie = movieRepository.findLastEntry();

        return movie.map(value -> value.getMovieDbId() + 1L).orElse(1L);
    }

    @Override
    @Transactional
    public void saveAllMovies(List<Movie> movies) {
        this.movieRepository.saveAll(movies);
    }

    @Override
    public MovieDto findMovieByMovieDbId(Long movieDbId) {

        return this.movieMapper.toDto(
                this.movieRepository.findMovieByMovieDbId(movieDbId).orElseThrow(() -> new MovieNotFoundException("Movie not found"))
        );
    }

    @Override
    public Page<MovieDto> findAllMovies(Pageable pageable) {
        return this.movieRepository.findAll(pageable).map(this.movieMapper::toDto);
    }
}
