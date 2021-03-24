package io.springboot2.x.service;

import io.springboot2.x.domain.NetflixDevice;
import io.springboot2.x.dto.NetflixDeviceDTO;
import io.springboot2.x.dto.NetflixDevicesDTO;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface INetflixDeviceService {
    boolean isDeviceExistOrNot(NetflixDeviceDTO netflixDeviceDTO);
    List<NetflixDevicesDTO> findByMobile(String phoneNor);
    boolean deleteByMobile(String phoneNor);

    public List<NetflixDevice> getAllNetflixDeviceDetailsV1();
    public List<NetflixDeviceDTO> getAllNetflixDeviceDetailsV2();
    public boolean deleteNetflixDeviceById(Integer id);


}
