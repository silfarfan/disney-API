package com.alkemy.disney.disney.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter @Setter
public class MovieBasicDTO {

    private Long id;
    private String title;
    private String img;
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate creationDate;

}
