package io.springboot2.x.service;

import io.springboot2.x.domain.NetflixTenure;
import io.springboot2.x.dto.NetflixTenure2DTO;
import io.springboot2.x.dto.NetflixTenureDTO;

import java.util.List;
import java.util.Optional;

public interface INetflixTenureService {
    public List<NetflixTenure2DTO> getByMobileNor(String phoneNor);
    public List<NetflixTenure2DTO> getAllNetflixTenureDetails();
    public boolean deleteNetflixTenureById(Integer id);
    public boolean addNetflixTenure(NetflixTenureDTO netflixTenureDTO);
    public boolean updateNetflixTenure(NetflixTenureDTO netflixTenureDTO);
}
