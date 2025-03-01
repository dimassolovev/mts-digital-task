package com.dimas.mtsdigitaltask.mapper;

import com.dimas.mtsdigitaltask.model.dto.MovieDto;
import com.dimas.mtsdigitaltask.model.entity.Movie;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MovieMapper extends Mappable<Movie, MovieDto> {
}
