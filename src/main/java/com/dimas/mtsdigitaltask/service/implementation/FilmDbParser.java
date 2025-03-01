package com.dimas.mtsdigitaltask.service.implementation;

import com.dimas.mtsdigitaltask.client.MovieDbClient;
import com.dimas.mtsdigitaltask.mapper.ExternalMovieMapper;
import com.dimas.mtsdigitaltask.model.entity.Movie;
import com.dimas.mtsdigitaltask.service.BackgroundTaskService;
import com.dimas.mtsdigitaltask.service.MovieService;
import feign.FeignException;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class FilmDbParser implements BackgroundTaskService {
    private final MovieDbClient movieDbClient;
    private final MovieService movieService;
    private final ExternalMovieMapper externalMovieMapper;
    private final List<Movie> movies = new ArrayList<>();
    private Long lastEntryId;

    @PostConstruct
    public void init() {
        this.lastEntryId = this.movieService.findLastEntryId();
    }

    @Override
    @Scheduled(fixedRate = 100)
    public void poll() {
        try {
            var movie = this.movieDbClient.searchMovieById(this.lastEntryId, "en");
            var entity = this.externalMovieMapper.toEntity(movie);
            entity.setMovieDbId(this.lastEntryId);
            entity.setBudget(entity.getBudget() == 0 ? null : entity.getBudget());

            this.movies.add(entity);
        }

        catch (FeignException exception) {
            log.error("Error while parsing movie, id: {}", this.lastEntryId);
        }

        if (movies.size() == 40) {
            this.movieService.saveAllMovies(movies);
            this.movies.clear();
        }

        this.lastEntryId++;
    }
}
