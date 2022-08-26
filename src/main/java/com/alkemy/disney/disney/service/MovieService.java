package com.alkemy.disney.disney.service;

import com.alkemy.disney.disney.dto.MovieBasicDTO;
import com.alkemy.disney.disney.dto.MovieDTO;
import com.alkemy.disney.disney.entity.MovieEntity;
import com.alkemy.disney.disney.mapper.MovieMapper;
import com.alkemy.disney.disney.repository.IMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService implements IMovieService {

    @Autowired
    private MovieMapper movieMapper;

    @Autowired
    private IMovieRepository movieRepository;

    @Override
    public MovieDTO saveMovie(MovieDTO dto) {
        MovieEntity entity = movieMapper.movieDTO2Entity(dto);
        MovieEntity entitySaved = movieRepository.save(entity);
        MovieDTO result = movieMapper.movieEntity2DTO(entitySaved, true, true);

        return result;
    }

    @Override
    public List<MovieDTO> getAllMovies() {
        List<MovieEntity> entities = movieRepository.findAll();
        List<MovieDTO> result = movieMapper.movieEntityList2DTOList(entities, true, true);
        return result;
    }

    @Override
    public void deleteMovieById(Long id) {
        movieRepository.deleteById(id);
    }

    @Override
    public MovieDTO updateMovie(Long id, MovieDTO movieDTO) {
        MovieEntity savedMovie = this.getMovieById(id);
        savedMovie.setTitle(movieDTO.getTitle());
        savedMovie.setImg(movieDTO.getImg());
        savedMovie.setCreationDate(movieDTO.getCreationDate()); //ver formato fecha
        savedMovie.setRating(movieDTO.getRating());
        MovieEntity movieEntity = movieRepository.save(savedMovie);
        MovieDTO result = movieMapper.movieEntity2DTO(movieEntity, true, true);
        return result;
    }

    @Override
    public MovieEntity getMovieById(Long id) {
        Optional<MovieEntity> movieEntity = movieRepository.findById(id);
/*        if (!movieEntity.isPresent()) {
            throw new ParamNotFound("La pelicula no existe.");
        }*/
        return movieEntity.get();
    }

    @Override
    public List<MovieBasicDTO> getBasicList() {
        List<MovieEntity> entities = movieRepository.findAll();
        List<MovieBasicDTO> dtos = movieMapper.movieBasicEntityList2DTOList(entities);
        return dtos;
    }
}