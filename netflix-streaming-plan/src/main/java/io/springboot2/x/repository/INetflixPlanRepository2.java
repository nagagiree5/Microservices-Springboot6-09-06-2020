package io.springboot2.x.repository;

import io.springboot2.x.domain.NetflixPlan;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface INetflixPlanRepository2 extends CrudRepository<NetflixPlan, String>, JpaSpecificationExecutor<NetflixPlan> {
}
