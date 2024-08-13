package com.mis.education.Education.MIS.repositories.customer_address;

import com.mis.education.Education.MIS.modules.customer_address.CustomerAddressEntity;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerAddressRepository extends DataTablesRepository<CustomerAddressEntity,Integer>, CustomerAddressRepositoryCustom {



}
