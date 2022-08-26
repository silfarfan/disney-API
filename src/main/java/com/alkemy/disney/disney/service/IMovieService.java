package com.alkemy.disney.disney.service;

import com.alkemy.disney.disney.dto.MovieBasicDTO;
import com.alkemy.disney.disney.dto.MovieDTO;
import com.alkemy.disney.disney.entity.MovieEntity;

import java.util.List;

public interface IMovieService {

    MovieDTO saveMovie(MovieDTO dto);
    List<MovieDTO> getAllMovies();
    void deleteMovieById(Long id);
    MovieDTO updateMovie(Long id, MovieDTO movieDTO);
    MovieEntity getMovieById(Long id);
    List<MovieBasicDTO> getBasicList();

}
