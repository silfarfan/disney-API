package com.alkemy.disney.disney.repository;

import com.alkemy.disney.disney.entity.PeliculaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPeliculaRepository extends JpaRepository <PeliculaEntity, Long> {
}