package io.springboot2.x.service.impl;

import io.springboot2.x.domain.NetflixPlan;
import io.springboot2.x.repository.INetflixPlanRepository2;
import io.springboot2.x.service.INetflixPlanService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class NetflixPlanService2Impl  implements INetflixPlanService2 {
    @Autowired
    private INetflixPlanRepository2 repo;

    @Override
    public List<NetflixPlan> byNetflixPlanNameLikeCriteria(String search) {
        return repo.findAll(new Specification<NetflixPlan>() {
            @Override
            public Predicate toPredicate(Root<NetflixPlan> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (search != null) {
                    predicates.add(criteriaBuilder.or(criteriaBuilder.like(root.get("planName"), "%" + search + "%")));
                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }

        });
    }

    @Override
    public List<NetflixPlan> byNetflixPlanPriceLikeCriteria(String search) {
        return repo.findAll(new Specification<NetflixPlan>() {
            @Override
            public Predicate toPredicate(Root<NetflixPlan> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (search != null) {
                    predicates.add(criteriaBuilder.or(criteriaBuilder.like(root.get("pricePerMonth"), "%" + search + "%")));
                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }

        });
    }
}
