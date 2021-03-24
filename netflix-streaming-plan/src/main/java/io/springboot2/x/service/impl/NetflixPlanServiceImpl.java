package io.springboot2.x.service.impl;

import io.springboot2.x.domain.NetflixPlan;
import io.springboot2.x.dto.NetflixPlanDTO;
import io.springboot2.x.repository.NetflixPlanRepository;
import io.springboot2.x.service.INetflixPlanService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NetflixPlanServiceImpl implements INetflixPlanService {
    @Autowired
    private NetflixPlanRepository repo;
    @Override
    public List<NetflixPlanDTO> getAllPlans() {
        List<NetflixPlan> netflixPlanList = repo.findAll();
        List<NetflixPlanDTO> netflixPlanDTOList = new ArrayList<>();
        netflixPlanList.forEach(netflixPlan -> {
            NetflixPlanDTO netflixPlanDTO = new NetflixPlanDTO();
            BeanUtils.copyProperties(netflixPlan, netflixPlanDTO);
            netflixPlanDTOList.add(netflixPlanDTO);
        });
        return netflixPlanDTOList;
    }

    @Override
    public NetflixPlanDTO getSpecificPlan(String id) {
        Optional<NetflixPlan> opt = repo.findById(id);

        NetflixPlanDTO netflixPlanDTO = new NetflixPlanDTO();
        if (opt.isPresent()) { // Is present then copyProperties if not copy allProperties are null...To avid
                                                        // 500 Excepton here... if
            NetflixPlan netflixPlan = opt.get();
            BeanUtils.copyProperties(netflixPlan, netflixPlanDTO);
            return netflixPlanDTO;
        }
        return netflixPlanDTO;
    }


    @Override
    public boolean deleteNetflixPlanById(String id) {
        boolean flag = repo.existsById(id);
        if (flag == true) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean addNetflixPlan(NetflixPlanDTO netflixPlanDTO) {
        NetflixPlan netflixPlan = new NetflixPlan();
        BeanUtils.copyProperties(netflixPlanDTO, netflixPlan);
        boolean flag = repo.existsById(netflixPlan.getPlanId());
        if (flag == true) {
            return false;
        }
        repo.save(netflixPlan);
        return true;
    }

    @Override
    public boolean updateNetflixPlan(NetflixPlanDTO netflixPlanDTO) {
        NetflixPlan netflixPlan = new NetflixPlan();
        BeanUtils.copyProperties(netflixPlanDTO, netflixPlan);
        boolean flag = repo.existsById(netflixPlan.getPlanId());
        if (flag == false) {
            return false;
        }
        repo.save(netflixPlan);
        return true;
    }
}
