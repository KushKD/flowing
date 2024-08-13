package com.mis.education.Education.MIS.repositories.user;

import com.mis.education.Education.MIS.modules.user.modal.LoggedInUserLocationSession;
import org.springframework.stereotype.Repository;
import com.mis.education.Education.MIS.modules.user.entity.UserEntity;

import java.util.List;

@Repository
public interface UserRepositoryCustom {

    List<UserEntity> getUserGeoData(String username_);
    UserEntity findByMobileNumber(Long mobile);
    UserEntity getUserDetails(Long mobile );

   Integer getCompanyId(String username);

   Long getTotalCustomers();
}
