package io.springboot2.x.repository;

import io.springboot2.x.domain.NetflixTenure;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface NetflixTenureRepository extends JpaRepository<NetflixTenure, Integer> {
    List<NetflixTenure> findByMobile(String phoneNor);
}
