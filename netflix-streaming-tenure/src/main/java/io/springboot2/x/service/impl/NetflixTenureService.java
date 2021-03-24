package io.springboot2.x.service.impl;

import io.springboot2.x.domain.NetflixTenure;
import io.springboot2.x.dto.NetflixTenure2DTO;
import io.springboot2.x.dto.NetflixTenureDTO;
import io.springboot2.x.repository.NetflixTenureRepository;
import io.springboot2.x.service.INetflixTenureService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NetflixTenureService implements INetflixTenureService {

    @Autowired
    private NetflixTenureRepository repo;

    @Override
    public List<NetflixTenure2DTO> getByMobileNor(String phoneNor) {
        List<NetflixTenure> netflixTenureList = repo.findByMobile(phoneNor);
        List<NetflixTenure2DTO> netflixTenure2DTOList = new ArrayList<>();
        netflixTenureList.forEach(netflixTenure -> {
            NetflixTenure2DTO netflixTenure2DTO = new NetflixTenure2DTO();
            BeanUtils.copyProperties(netflixTenure, netflixTenure2DTO);
            netflixTenure2DTOList.add(netflixTenure2DTO);
        });
        return netflixTenure2DTOList;
    }

    @Override
    public List<NetflixTenure2DTO> getAllNetflixTenureDetails() {
        List<NetflixTenure> netflixTenureList = repo.findAll();
        List<NetflixTenure2DTO> netflixTenure2DTOList = new ArrayList<>();
        netflixTenureList.forEach(netflixTenure -> {
            NetflixTenure2DTO netflixTenure2DTO = new NetflixTenure2DTO();
            BeanUtils.copyProperties(netflixTenure, netflixTenure2DTO);
            netflixTenure2DTOList.add(netflixTenure2DTO);
        });
        return netflixTenure2DTOList;
    }

    @Override
    public boolean deleteNetflixTenureById(Integer id) {
        boolean flag = repo.existsById(id);
        if (flag == true) {
            repo.deleteById(id);
            return true;
        }
        return false;

    }

    @Override
    public boolean addNetflixTenure(NetflixTenureDTO netflixTenureDTO) {
        NetflixTenure netflixTenure = new NetflixTenure();
        BeanUtils.copyProperties(netflixTenureDTO, netflixTenure);
        boolean flag = repo.existsById(netflixTenure.getId());
        if (flag == true) {
            return false;
        }
        repo.save(netflixTenure);
        return true;

    }

    @Override
    public boolean updateNetflixTenure(NetflixTenureDTO netflixTenureDTO) {
        NetflixTenure netflixTenure = new NetflixTenure();
        BeanUtils.copyProperties(netflixTenureDTO, netflixTenure);
        boolean flag = repo.existsById(netflixTenure.getId());
        if (flag == true) {
            repo.saveAndFlush(netflixTenure);
            return true;
        }
        return false;

    }


}
