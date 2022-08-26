package com.alkemy.disney.disney.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class CharFilterDTO {
    private String name;
    private int age;
    private Set<Long> movies;
    private String order;

    public CharFilterDTO() {
    }

    public CharFilterDTO(String name, int age, Set<Long> movies, String order) {
        this.name = name;
        this.age = age;
        this.movies = movies;
        this.order = order;
    }

    public boolean isASC() {
        return order.compareToIgnoreCase("ASC") == 0;
    }

    public boolean isDESC( {
        return order.compareToIgnoreCase("DESC") == 0;
    })

}
