package com.alkemy.disney.disney.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class MovieDTO {

    private Long id;
    private String title;
    private String img;
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate creationDate;
    private int rating;
    private List<GenreDTO> genres;
    private List<CharDTO> characters;

    public MovieDTO(){
    }

    public MovieDTO(Long id, String title, String img, LocalDate creationDate, int rating, List<GenreDTO> genres, List<CharDTO> characters) {
        this.id = id;
        this.title = title;
        this.img = img;
        this.creationDate = creationDate;
        this.rating = rating;
        this.genres = genres;
        this.characters = characters;
    }
}
