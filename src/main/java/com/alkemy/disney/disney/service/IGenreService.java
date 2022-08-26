package com.alkemy.disney.disney.service;

import com.alkemy.disney.disney.dto.GenreDTO;

import java.util.List;

public interface IGenreService {

    GenreDTO saveGenre(GenreDTO dto);
    List<GenreDTO> getAllGenres();
}
