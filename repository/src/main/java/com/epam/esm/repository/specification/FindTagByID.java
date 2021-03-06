package com.epam.esm.repository.specification;

import com.epam.esm.entity.Tag;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public final class FindTagByID extends FindSpecification<Tag> {

    private Long id;

    public FindTagByID(Long id) {
        this.id = id;
    }

    @Override
    public Query getQuery(EntityManager manager, CriteriaBuilder builder) {
        CriteriaQuery<Tag> criteriaQuery = builder.createQuery(Tag.class);
        Root<Tag> root = criteriaQuery.from(Tag.class);
        criteriaQuery.select(root).where(builder.equal(root.get("id"), this.id));
        return manager.createQuery(criteriaQuery);
    }
}
