package com.mis.education.Education.MIS.repositories.roles;

import com.mis.education.Education.MIS.modules.role.entity.RolesEntity;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
@CacheConfig(cacheNames = "roles")
public interface RolesRepository extends DataTablesRepository<RolesEntity, Long>,RolesRepositoryCustom {



}