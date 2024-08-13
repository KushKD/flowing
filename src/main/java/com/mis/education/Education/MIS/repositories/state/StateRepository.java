package com.mis.education.Education.MIS.repositories.state;


import com.mis.education.Education.MIS.modules.states.StatesMaster;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@CacheConfig(cacheNames = "states")
public interface StateRepository extends DataTablesRepository<StatesMaster,Integer>, StateRepositoryCustom {


}