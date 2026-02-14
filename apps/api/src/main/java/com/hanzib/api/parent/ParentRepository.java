package com.hanzib.api.parent;

import com.hanzib.api.family.Family;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ParentRepository {

    private final EntityManager em;

    public void save(Parent parent) {
        em.persist(parent);
    }

    public Parent findOneById(Long id) {
        return em.find(Parent.class, id);
    }

}