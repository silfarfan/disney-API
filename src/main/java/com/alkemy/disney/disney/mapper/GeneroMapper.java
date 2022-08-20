package com.alkemy.disney.disney.mapper;

import com.alkemy.disney.disney.dto.GeneroDTO;
import com.alkemy.disney.disney.entity.GeneroEntity;
import org.springframework.stereotype.Component;

@Component
public class GeneroMapper {

     public GeneroEntity generoDTO2Entity (GeneroDTO dto) {
         GeneroEntity generoEntity = new GeneroEntity();
         generoEntity.setNombre(dto.getNombre());
         generoEntity.setImagen(dto.getImagen());
         return generoEntity;
     }

     public GeneroDTO generoEntity2DTO (GeneroEntity entity) {
         GeneroDTO generoDTO = new GeneroDTO();
         generoDTO.setId(entity.getId());
         generoDTO.setNombre(entity.getNombre());
         generoDTO.setImagen(entity.getImagen());
         return generoDTO;
     }

}
