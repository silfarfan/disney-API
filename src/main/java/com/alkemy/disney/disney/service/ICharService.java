package com.alkemy.disney.disney.service;

import com.alkemy.disney.disney.dto.CharBasicDTO;
import com.alkemy.disney.disney.dto.CharDTO;
import com.alkemy.disney.disney.entity.CharEntity;

import java.util.List;
import java.util.Set;

public interface ICharService {

    CharDTO saveChar(CharDTO dto);
    List<CharDTO> getAllCharacters();
    List<CharBasicDTO> getCharBasicList;
    void deleteCharById(Long id);
    CharDTO getDetailsById(Long id);
    CharEntity getCharById(Long id);
    CharDTO updateChar(Long id, CharDTO charDTO);
    List<CharDTO> getCharactersByFilters(String name, int age, Set<Long> movies, String order);
    void addMovie(Long id, Long idMovie);
    void deleteMovie(Long id, Long idMovie);
}
