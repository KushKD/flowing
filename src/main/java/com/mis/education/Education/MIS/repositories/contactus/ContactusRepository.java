package com.mis.education.Education.MIS.repositories.contactus;

import com.mis.education.Education.MIS.modules.contactus.ContactusEntity;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactusRepository extends DataTablesRepository<ContactusEntity,Integer>,ContactusRepositoryCustom {
}
