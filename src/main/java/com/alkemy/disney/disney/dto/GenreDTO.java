package com.alkemy.disney.disney.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenreDTO {

    private Long id;
    private String name;
    private String img;


    public GenreDTO() {
    }

    public GenreDTO(Long id, String name, String img) {
        this.id = id;
        this.name = name;
        this.img = img;
    }
}




