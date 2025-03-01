package com.dimas.mtsdigitaltask.mapper;

import com.dimas.mtsdigitaltask.model.entity.Movie;
import com.dimas.mtsdigitaltask.model.external.ExternalMovie;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExternalMovieMapper extends Mappable<Movie, ExternalMovie> {
}
