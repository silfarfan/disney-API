package com.alkemy.disney.disney.mapper;

import com.alkemy.disney.disney.dto.GenreDTO;
import com.alkemy.disney.disney.dto.MovieBasicDTO;
import com.alkemy.disney.disney.dto.MovieDTO;
import com.alkemy.disney.disney.dto.CharDTO;
import com.alkemy.disney.disney.entity.MovieEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MovieMapper {

    @Lazy
    @Autowired
    private CharMapper charMapper;

    @Lazy
    @Autowired
    private GenreMapper genreMapper;

//    @Autowired
//    public MovieMapper(@Lazy GenreMapper genreMapper, CharMapper charMapper) {
//        this.genreMapper = genreMapper;
//        this.charMapper = charMapper;
//    }


    public MovieEntity movieDTO2Entity(MovieDTO dto) {
        MovieEntity movieEntity = new MovieEntity();

        movieEntity.setTitle(dto.getTitle());
        movieEntity.setImg(dto.getImg());
        movieEntity.setCreationDate(dto.getCreationDate());
        movieEntity.setRating(dto.getRating());
        movieEntity.setGenres(this.genreMapper.genreDTOList2EntityList(dto.getGenres()));
        movieEntity.setCharacters(this.charMapper.charDTOList2EntityList(dto.getCharacters()));
        return movieEntity;
    }

    public MovieDTO movieEntity2DTO(MovieEntity entity, boolean loadCharacters, boolean loadGenres) {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setId(entity.getId());
        movieDTO.setTitle(entity.getTitle());
        movieDTO.setImg(entity.getImg());
        movieDTO.setCreationDate(entity.getCreationDate());
        movieDTO.setRating(entity.getRating());

        if(loadCharacters) {
            List<CharDTO> characters = this.charMapper.charEntityList2DTOList(entity.getCharacters(), false);
            movieDTO.setCharacters(characters);
        }

        if(loadGenres) {
            List<GenreDTO> genres = this.genreMapper.genreEntityList2DTOList(entity.getGenres());
            movieDTO.setGenres(genres);
        }
        return movieDTO;
    }


    public List<MovieDTO> movieEntityList2DTOList(List<MovieEntity> entities, boolean loadCharacters, boolean loadGenres) {
        List<MovieDTO> dtos = new ArrayList<>();
        for (MovieEntity entity : entities) {
            dtos.add(this.movieEntity2DTO(entity, loadCharacters, loadGenres));
        }
        return dtos;
    }

    public List<MovieEntity> movieDTOList2EntityList(List<MovieDTO> dtos, boolean loadCharacters, boolean loadGenres) {
        List<MovieEntity> entities = new ArrayList<>();
        for (MovieDTO dto : dtos) {
            entities.add(this.movieDTO2Entity(dto));
        }
        return entities;
    }

    public MovieBasicDTO movieBasicEntity2DTO(MovieEntity entity) {
        MovieBasicDTO dto = new MovieBasicDTO();
        dto.setTitle(entity.getTitle());
        dto.setImg(entity.getImg());
        dto.setCreationDate(entity.getCreationDate());

        //Cambiar formato fecha a string en entity
//        LocalDate fecha = entity.getCreationDate();
//        String formatoFecha = fecha.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
//        dto.setCreationDate(formatoFecha);

        return dto;
    }

    public List<MovieBasicDTO> movieBasicEntityList2DTOList(List<MovieEntity> entities) {
        List<MovieBasicDTO> dtos = new ArrayList<>();
        for (MovieEntity entity : entities) {
            dtos.add(this.movieBasicEntity2DTO(entity));
        }
        return dtos;
    }


}


