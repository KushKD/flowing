package com.mis.education.Education.MIS.repositories.userdatatables;

import com.mis.education.Education.MIS.modules.user.entity.UserEntity;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDatatableRepository extends DataTablesRepository<UserEntity,Long>,UserDatatableRepositoryCustom {



}
