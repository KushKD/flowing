package com.mis.education.Education.MIS.repositories.cart;

import com.mis.education.Education.MIS.modules.cart.CartEntity;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends DataTablesRepository<CartEntity,Integer>,CartRepositoryCustom {


}
