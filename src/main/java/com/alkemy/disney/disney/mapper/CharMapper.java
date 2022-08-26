package com.alkemy.disney.disney.mapper;

import com.alkemy.disney.disney.dto.MovieDTO;
import com.alkemy.disney.disney.dto.CharBasicDTO;
import com.alkemy.disney.disney.dto.CharDTO;
import com.alkemy.disney.disney.entity.CharEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CharMapper {

    @Autowired
    private MovieMapper movieMapper;



    public CharEntity charDTO2Entity(CharDTO dto) {
        CharEntity charEntity = new CharEntity();
        charEntity.setName(dto.getName());
        charEntity.setImg(dto.getImg());
        charEntity.setEdad(dto.getAge());
        charEntity.setWeight(dto.getWeight());
        charEntity.setStory(dto.getStory());
        return charEntity;
    }

    public CharDTO charEntity2DTO(CharEntity entity, boolean loadMovies) {
        CharDTO charDTO = new CharDTO();
        charDTO.setId(entity.getId());
        charDTO.setName(entity.getName());
        charDTO.setImg(entity.getImg());
        charDTO.setAge(entity.getEdad());
        charDTO.setWeight(entity.getWeight());
        charDTO.setStory(entity.getStory());

        if (loadMovies){
            List<MovieDTO> movies = this.movieMapper.movieEntityList2DTOList(entity.getMovies(), false, false);
            charDTO.setMovies(movies);
        }
        return charDTO;
    }

    public List<CharDTO> charEntityList2DTOList(List<CharEntity> entities, boolean loadMovies) {
        List<CharDTO> dtos = new ArrayList<>();
        for (CharEntity entity : entities) {
            dtos.add(this.charEntity2DTO(entity, loadMovies));
        }
        return dtos;
    }

    public List<CharEntity> charDTOList2EntityList(List<CharDTO> dtos) {
        List<CharEntity> entities = new ArrayList<>();
        for (CharDTO dto : dtos) {
            entities.add(charDTO2Entity(dto));
        }
        return entities;
    }

    public CharBasicDTO charBasicEntity2DTO(CharEntity entity) {
        CharBasicDTO dto = new CharBasicDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setImg(entity.getImg());
        return dto;
    }

    public List<CharBasicDTO> charBasicEntityList2DTOList(List<CharEntity> entities) {
        List<CharBasicDTO> dtos = new ArrayList<>();
        for (CharEntity entity : entities) {
            dtos.add(this.charBasicEntity2DTO(entity));
        }
        return dtos;
    }
}
