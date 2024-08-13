package com.mis.education.Education.MIS.repositories.orders;

import com.mis.education.Education.MIS.modules.order.OrdersEntity;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;

@Repository
public interface OrdersRepository extends DataTablesRepository<OrdersEntity,Integer>, OrdersRepositoryCustom {

}
