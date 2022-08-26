package com.alkemy.disney.disney.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "genre")
@Getter
@Setter
@SQLDelete(sql = "UPDATE genre SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class GenreEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    private String img;

    private boolean deleted = Boolean.FALSE;

    @ManyToMany(mappedBy = "genres", cascade = CascadeType.ALL)
    private List<MovieEntity> movies = new ArrayList<>();

    public GenreEntity(){
    }

    public GenreEntity(Long id, String name, String img) {
        this.id = id;
        this.name = name;
        this.img = img;
    }
}
