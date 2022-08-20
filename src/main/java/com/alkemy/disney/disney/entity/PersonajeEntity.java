package com.alkemy.disney.disney.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "personaje")
@Getter
@Setter
public class PersonajeEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nombre;

    private String imagen;

    private int edad;

    private int peso;

    private String historia;

    @ManyToMany(mappedBy = "personajes", cascade = CascadeType.ALL)
    private List<PeliculaEntity> peliculas = new ArrayList<>();


    public PersonajeEntity() {
    }

    public PersonajeEntity(Long id, String nombre, String imagen, int edad, int peso, String historia) {
        this.id = id;
        this.nombre = nombre;
        this.imagen = imagen;
        this.edad = edad;
        this.peso = peso;
        this.historia = historia;
    }
}
