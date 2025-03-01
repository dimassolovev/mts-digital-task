package com.dimas.mtsdigitaltask.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class MovieDto {
    private Long budget;

    @JsonProperty("original_title")
    private String originalTitle;

    @JsonProperty("title")
    private String title;

    @JsonProperty("release_date")
    private LocalDate releaseDate;

    @JsonProperty("vote_average")
    private Double voteAverage;

    @JsonProperty("movie_db_id")
    private Long movieDbId;

    @JsonProperty("vote_count")
    private Long voteCount;

    @JsonProperty("genre_list")
    private List<GenreDto> genres;
}
