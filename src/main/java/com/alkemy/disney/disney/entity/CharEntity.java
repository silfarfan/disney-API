package com.alkemy.disney.disney.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "char")
@Getter
@Setter
@SQLDelete(sql = "UPDATE char SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class CharEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    private String img;

    private int edad;

    private int weight;

    private String story;

    private boolean deleted = Boolean.FALSE;

    @ManyToMany(mappedBy = "characters", cascade = CascadeType.ALL)
    private List<MovieEntity> movies = new ArrayList<>();


    public CharEntity() {
    }

    public CharEntity(Long id, String name, String img, int edad, int weight, String story) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.edad = edad;
        this.weight = weight;
        this.story = story;
    }
}
