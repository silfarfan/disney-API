package com.alkemy.disney.disney.repository.specification;

import antlr.StringUtils;
import com.alkemy.disney.disney.dto.CharFilterDTO;
import com.alkemy.disney.disney.entity.MovieEntity;
import com.alkemy.disney.disney.entity.CharEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Component
public class CharSpecification {
    public Specification<CharEntity> getByFilters(CharFilterDTO filterDTO) {

        //Funcion Lambda
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if(StringUtils.hasLength(filterDTO.getName())) {
                predicates.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("name")),
                                "%" + filterDTO.getName().toLowerCase() + "%"));
            }

            if(filterDTO.getAge() != null) {
                predicates.add(
                        criteriaBuilder.equal
                                (root.get("age"), filterDTO.getAge()));
            }

            if(!CollectionUtils.isEmpty(filterDTO.getMovies())) {
                Join<MovieEntity, CharEntity> join = root.join("movies", JoinType.INNER);
                Expression<String> peliculasId = join.get("id");
                predicates.add(peliculasId.in(filterDTO.getMovies()));
            }

            //Remover duplicados
            query.distinct(true);

            //Orden
            String orderByField = "name";
            query.orderBy(
                    filterDTO.isASC() ?
                            criteriaBuilder.asc(root.get(orderByField)) :
                            criteriaBuilder.desc(root.get(orderByField))
            );

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }



}
