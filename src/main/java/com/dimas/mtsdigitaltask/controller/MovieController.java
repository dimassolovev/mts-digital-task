package com.dimas.mtsdigitaltask.controller;

import com.dimas.mtsdigitaltask.model.dto.MovieDto;
import com.dimas.mtsdigitaltask.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/films")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> getMovieById(@PathVariable Long id) {
        return ResponseEntity.ok(this.movieService.findMovieByMovieDbId(id));
    }

    @GetMapping("/list")
    public ResponseEntity<Page<MovieDto>> getMovies(
            Pageable pageable
    ) {
        return ResponseEntity.ok(this.movieService.findAllMovies(pageable));
    }
}
