package com.dimas.mtsdigitaltask.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "movie", schema = "films_schema")
@Data
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long budget;

    @Column(name = "original_title") // , nullable = false
    private String originalTitle;

    @Column(name = "title") // , nullable = false
    private String title;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "vote_average")
    private Double voteAverage;

    @Column(name = "movie_db_id", unique = true) // , nullable = false
    private Long movieDbId;

    @Column(name = "vote_count")
    private Long voteCount;

    @ManyToMany
    @JoinTable(
            name = "movie_genre",
            schema = "films_schema",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private List<Genre> genres;
}


