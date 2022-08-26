package com.alkemy.disney.disney.repository;

import com.alkemy.disney.disney.entity.CharEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICharRepository extends JpaRepository <CharEntity, Long> {
    List<CharEntity> findAll(Specification<CharEntity> specification);

}
