package io.springboot2.x.repository;

import io.springboot2.x.domain.NetflixPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;

public interface NetflixPlanRepository extends JpaRepository<NetflixPlan, String> {
}
