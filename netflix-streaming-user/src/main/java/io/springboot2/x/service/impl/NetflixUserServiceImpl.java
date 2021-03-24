package io.springboot2.x.service.impl;

import io.springboot2.x.domain.NetflixUser;
import io.springboot2.x.dto.*;
import io.springboot2.x.repository.NetflixUserRepository;
import io.springboot2.x.service.INetflixUserService;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NetflixUserServiceImpl implements INetflixUserService {

    @Autowired
    private NetflixUserRepository repo;
    @Override
    public boolean registerUser(RegisterNetflixDTO registerNetflixDTO) {
        NetflixUser netflixUser = new NetflixUser();
        BeanUtils.copyProperties(registerNetflixDTO, netflixUser);
        boolean flag = repo.existsById(netflixUser.getPhoneNor());
        if (flag == true) {
            return false;
        }
        repo.save(netflixUser);
        return true;

    }

    @Override
    public boolean loginUser(LoginNetflixDTO loginNetflixDTO) {
        if(repo.isVerifyPhoneNorAndPassword(loginNetflixDTO.getPhoneNor(),loginNetflixDTO.getPassword())==1){
            return true;
        }
        return false;
    }

    @Override
    public NetflixUserDTO readUser(String phoneNor) {


/*      NetflixUser netflixUser=repo.findById(phoneNor).get();
        NetflixUserDTO  netflixUserDTO=new  NetflixUserDTO();
        BeanUtils.copyProperties(netflixUser,netflixUserDTO);
        return netflixUserDTO;*/

        Optional<NetflixUser> opt = repo.findById(phoneNor);
        NetflixUserDTO  netflixUserDTO=new  NetflixUserDTO();
        if (opt.isPresent()) {
            NetflixUser netflixUser = opt.get();
            BeanUtils.copyProperties(netflixUser, netflixUserDTO);
            return netflixUserDTO;
        }
        return netflixUserDTO;
    }

    @Override
    public NetflixUser2DTO readUserV2(String phoneNor) {
        Optional<NetflixUser> opt = repo.findById(phoneNor);
        NetflixUser2DTO  netflixUser2DTO=new  NetflixUser2DTO();
        if (opt.isPresent()) {
            NetflixUser netflixUser = opt.get();
            BeanUtils.copyProperties(netflixUser, netflixUser2DTO);
            return netflixUser2DTO;
        }
        return netflixUser2DTO;
    }


    @Override
    public boolean updateUser(RegisterNetflixDTO registerNetflixDTO) {
        NetflixUser netflixUser = new NetflixUser();
        BeanUtils.copyProperties(registerNetflixDTO, netflixUser);
        boolean flag = repo.existsById(netflixUser.getPhoneNor());
        if (flag ==false ) {
            return false;
        }
        repo.saveAndFlush(netflixUser);
        return true;

    }

    @Override
    public boolean deleteUserByPhoneNor(String phoneNor) {
        if(repo.existsById(phoneNor)==true){
            repo.deleteById(phoneNor);
            return true;
        }
        return false;
    }

    @Override
    public boolean getUpdatePlanId(NetflixPlanUpdateDTO netflixPlanUpdateDTO) {
        if(repo.existsById(netflixPlanUpdateDTO.getPhoneNor())==true){
            repo.updatePlan(netflixPlanUpdateDTO.getPhoneNor(),netflixPlanUpdateDTO.getPlanId());
            return true;
        }
        return false;
    }
    @Override
    public boolean updateUserV2(NetflixUser2DTO netflixUser2DTO) {
        NetflixUser netflixUser = new NetflixUser();
        BeanUtils.copyProperties(netflixUser2DTO, netflixUser);
        boolean flag = repo.existsById(netflixUser.getPhoneNor());
        if (flag ==false ) {
            return false;
        }
        NetflixUser netflix=repo.findById(netflixUser.getPhoneNor()).get();
        netflixUser.setPassword(netflix.getPassword());
        repo.saveAndFlush(netflixUser);
        return true;

    }

}
