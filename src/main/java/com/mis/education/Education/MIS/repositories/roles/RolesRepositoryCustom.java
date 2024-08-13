package com.mis.education.Education.MIS.repositories.roles;

import com.mis.education.Education.MIS.modules.role.entity.RolesEntity;
import com.mis.education.Education.MIS.modules.role.modal.RolesModal;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@CacheConfig(cacheNames = "roles_")
public interface RolesRepositoryCustom {


    @Cacheable
    List<RolesModal> getRoles();


    Boolean checkRole(String rolenmae);

     @Cacheable
    List<RolesModal> getRoleVendor();


    RolesEntity getRoleViaId(Integer roleId) throws Exception;
}
