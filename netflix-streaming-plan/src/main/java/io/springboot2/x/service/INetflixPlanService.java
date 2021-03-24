package io.springboot2.x.service;

import io.springboot2.x.dto.NetflixPlanDTO;

import java.util.List;
import java.util.Optional;

public interface INetflixPlanService {
    List<NetflixPlanDTO> getAllPlans();
    NetflixPlanDTO getSpecificPlan(String id);
    boolean deleteNetflixPlanById(String id);

    boolean addNetflixPlan(NetflixPlanDTO netflixPlanDTO);
    boolean updateNetflixPlan(NetflixPlanDTO netflixPlanDTO);

}
