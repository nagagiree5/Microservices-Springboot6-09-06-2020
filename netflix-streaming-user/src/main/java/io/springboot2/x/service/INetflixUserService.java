package io.springboot2.x.service;

import io.springboot2.x.dto.*;

public interface INetflixUserService {

    boolean registerUser(RegisterNetflixDTO registerNetflixDTO);
    boolean loginUser(LoginNetflixDTO loginNetflixDTO);
    NetflixUserDTO readUser(String phoneNor);
    NetflixUser2DTO readUserV2(String phoneNor);
    boolean updateUser(RegisterNetflixDTO registerNetflixDTO);
    boolean updateUserV2(NetflixUser2DTO netflixUser2DTO);
    boolean deleteUserByPhoneNor(String phoneNor);

    boolean getUpdatePlanId(NetflixPlanUpdateDTO netflixPlanUpdateDTO);

}
