package com.alkemy.disney.disney.dto;

import com.alkemy.disney.disney.entity.MovieEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class CharDTO {

    private Long id;
    private String name;
    private String img;
    private int age;
    private int weight;
    private String story;
    private List<MovieDTO> movies;

    public CharDTO() {
    }

    public CharDTO(Long id, String name, String img, int age, int weight, String story, List<MovieEntity> movies) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.age = age;
        this.weight = weight;
        this.story = story;

    }
}
