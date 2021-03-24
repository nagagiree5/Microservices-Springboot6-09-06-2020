package io.springboot2.x.service.impl;

import io.springboot2.x.domain.NetflixDevice;
import io.springboot2.x.dto.NetflixDeviceDTO;
import io.springboot2.x.dto.NetflixDevicesDTO;
import io.springboot2.x.repository.NetflixDeviceRepository;
import io.springboot2.x.service.INetflixDeviceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NetflixDeviceServiceImpl implements INetflixDeviceService {

    @Autowired
    private NetflixDeviceRepository repo;
    @Override
    public boolean isDeviceExistOrNot(NetflixDeviceDTO netflixDeviceDTO) {
        NetflixDevice netflixDevice = new NetflixDevice();

        Integer i=repo.isDeviceExistOrNot(netflixDeviceDTO.getMobile(),netflixDeviceDTO.getDevice());
        if(i==0){
            BeanUtils.copyProperties(netflixDeviceDTO, netflixDevice);
            repo.saveAndFlush(netflixDevice);
            return true;
        }
        return false;
    }

    @Override
    public List<NetflixDevicesDTO> findByMobile(String phoneNor) {
        List<NetflixDevice> netflixDeviceList = repo.findByMobile(phoneNor);
        List<NetflixDevicesDTO> netflixDeviceDTOList = new ArrayList<>();
        netflixDeviceList.forEach(netflixDevice -> {
            NetflixDevicesDTO netflixDeviceDTO = new NetflixDevicesDTO();
            BeanUtils.copyProperties(netflixDevice, netflixDeviceDTO);
            netflixDeviceDTOList.add(netflixDeviceDTO);
        });
        return netflixDeviceDTOList;
    }

    @Override
    public boolean deleteByMobile(String phoneNor) {
        Integer i=repo.deleteByMobile(phoneNor);
        if(i==1){
            return true;
        }
        return false;
    }

    @Override
    public List<NetflixDevice> getAllNetflixDeviceDetailsV1() {
        return repo.findAll();
    }

    @Override
    public List<NetflixDeviceDTO> getAllNetflixDeviceDetailsV2() {
        List<NetflixDevice> netflixDeviceList = repo.findAll();
        List<NetflixDeviceDTO> netflixDeviceDTOList = new ArrayList<>();
        netflixDeviceList.forEach(netflixDevice -> {
            NetflixDeviceDTO netflixDeviceDTO = new NetflixDeviceDTO();
            BeanUtils.copyProperties(netflixDevice, netflixDeviceDTO);
            netflixDeviceDTOList.add(netflixDeviceDTO);
        });
        return netflixDeviceDTOList;
    }

    @Override
    public boolean deleteNetflixDeviceById(Integer id) {
        boolean flag = repo.existsById(id);
        if (flag == true) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }


}
