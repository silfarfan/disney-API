package com.alkemy.disney.disney.service;

import com.alkemy.disney.disney.dto.CharDTO;
import com.alkemy.disney.disney.dto.CharFilterDTO;
import com.alkemy.disney.disney.entity.MovieEntity;
import com.alkemy.disney.disney.entity.CharEntity;
import com.alkemy.disney.disney.mapper.MovieMapper;
import com.alkemy.disney.disney.mapper.CharMapper;
import com.alkemy.disney.disney.repository.ICharRepository;
import com.alkemy.disney.disney.repository.specification.CharSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CharService implements ICharService {

    @Autowired
    private CharMapper charMapper;

    @Autowired
    private ICharRepository charRepository;

    @Autowired
    private MovieMapper movieMapper;

    @Lazy
    @Autowired
    private IMovieService charService;

    @Autowired
    private CharSpecification charSpecification;

    @Override
    public CharDTO saveChar(CharDTO dto) {
        CharEntity entity = charMapper.charDTO2Entity(dto);
        CharEntity entitySaved = charRepository.save(entity);
        CharDTO result = charMapper.charEntity2DTO(entitySaved, false);

        return result;
    }

    @Override
    public List<CharDTO> getAllCharacters() {
        List<CharEntity> entities = charRepository.findAll();
        List<CharDTO> result = charMapper.charEntityList2DTOList(entities, true);
        return result;
    }

    @Override
    public void deleteCharById(Long id){
        charRepository.deleteById(id);
    }

    @Override
    public CharEntity getCharById(Long id) {
        Optional<CharEntity> charEntity = charRepository.findById(id);
 /*       if (!charEntity.isPresent()){
            throw new ParamNotFound("Este personaje no existe");
        }*/
        return charEntity.get();
    }

    @Override
    public CharDTO updateChar(Long id, CharDTO charDTO) {
        CharEntity savedChar = this.getCharById(id);
        savedChar.setName(charDTO.getName());
        savedChar.setImg(charDTO.getImg());
        savedChar.setEdad(charDTO.getAge());
        savedChar.setWeight(charDTO.getWeight());
        savedChar.setStory(charDTO.getStory());
        savedChar.setMovies(movieMapper.movieDTOList2EntityList(
                charDTO.getMovies(), false, false));
        CharEntity editedChar = charRepository.save(savedChar);
        CharDTO DTOSaved = charMapper.charEntity2DTO(editedChar, false);

        return DTOSaved;

    }

    @Override
    public List<CharDTO> getCharactersByFilters(String name, int age, Set<Long> movies, String order) {
        CharFilterDTO charFilter = new CharFilterDTO(name, age, movies, order);
        List<CharEntity> entities = charRepository.findAll(charSpecification.getByFilters(charFilter));
        List<CharDTO> result = charMapper.charEntityList2DTOList(entities, true);
        return result;
    }

    @Override
    public void addMovie(Long id, Long idMovie) {
        CharEntity charEntity = charRepository.getById(id);
        charEntity.getMovies().size();
        MovieEntity movie = this.charService.getMovieById(idMovie);
        charEntity.getMovies().add(movie);
        this.charRepository.save(charEntity);
    }

    @Override
    public void deleteMovie(Long id, Long idMovie) {
        CharEntity charEntity = charRepository.getById(id);
        charEntity.getMovies().size();
        MovieEntity movie = this.charService.getMovieById(idMovie);
        charEntity.getMovies().remove(movie);
        this.charRepository.save(charEntity);
    }

    @Override
    public CharDTO getDetailsById(Long id) {
        CharEntity entity = this.getCharById(id);
        CharDTO dto = charMapper.charEntity2DTO(entity, true);
        return dto;
    }


}
