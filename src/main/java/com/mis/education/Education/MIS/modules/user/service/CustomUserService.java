package com.mis.education.Education.MIS.modules.user.service;


import com.mis.education.Education.MIS.modules.user.entity.UserEntity;

public interface CustomUserService {


    void save(UserEntity user);
    UserEntity findByUsername(String userName);
    UserEntity findByMobileNumber(String mobileNumber);

    UserEntity findByEmail(String email);
}
