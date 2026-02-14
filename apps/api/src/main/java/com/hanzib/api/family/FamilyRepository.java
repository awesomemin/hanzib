package com.hanzib.api.family;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class FamilyRepository {

    private final EntityManager em;

    public void save(Family family) {
        em.persist(family);
    }

    public Family findOneById(Long familyId) {
        return em.find(Family.class, familyId);
    }

    public boolean checkIfExist(Long familyId) {
        Family family = em.find(Family.class, familyId);
        return family != null;
    }

    public boolean existsByCreatedById(Long createdById) {
        Long count = em.createQuery(
                        "select count(f) from Family f where f.createdBy.id = :createdById",
                        Long.class
                )
                .setParameter("createdById", createdById)
                .getSingleResult();
        return count > 0;
    }
}
