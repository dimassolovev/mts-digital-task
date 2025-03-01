package com.dimas.mtsdigitaltask.client;

import com.dimas.mtsdigitaltask.configuration.MovieDbFeignClientConfig;
import com.dimas.mtsdigitaltask.model.external.ExternalMovie;
import com.dimas.mtsdigitaltask.model.external.Genres;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "movieDbClient", configuration = MovieDbFeignClientConfig.class)
public interface MovieDbClient {
    @GetMapping(value = "/3/search/movie")
    ExternalMovie searchMovieByName(
            @RequestParam("query") String query,
            @RequestParam("language") String language
    );

    @GetMapping(value = "/3/movie/{id}")
    ExternalMovie searchMovieById(
            @PathVariable Long id,
            @RequestParam("language") String language
    );

    @GetMapping(value = "/3/genre/movie/list")
    Genres getGenres(
            @RequestParam("language") String language
    );
}
