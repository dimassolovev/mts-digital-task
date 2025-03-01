package com.dimas.mtsdigitaltask.repository;

import com.dimas.mtsdigitaltask.model.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query(value = "SELECT * FROM films_schema.movie ORDER BY id DESC LIMIT 1", nativeQuery = true)
    Optional<Movie> findLastEntry();

    Optional<Movie> findMovieByMovieDbId(Long movieDbId);


}
