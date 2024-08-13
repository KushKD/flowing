package com.mis.education.Education.MIS.repositories.customer_address;

import com.mis.education.Education.MIS.modules.customer_address.CustomerAddressEntity;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerAddressRepositoryCustom  {

    List<CustomerAddressEntity> getAddressByUSerId(Integer userId);

    CustomerAddressEntity getAddressByAddressId(Integer addressId);

    void deleteRow(Integer id);
}
