package io.springboot2.x.service;

import io.springboot2.x.domain.NetflixPlan;

import java.util.List;

public interface INetflixPlanService2 {

    public List<NetflixPlan> byNetflixPlanNameLikeCriteria(String search);
    public List<NetflixPlan> byNetflixPlanPriceLikeCriteria(String search);
}
