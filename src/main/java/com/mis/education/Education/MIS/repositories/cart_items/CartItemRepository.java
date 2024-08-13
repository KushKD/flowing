package com.mis.education.Education.MIS.repositories.cart_items;

import com.mis.education.Education.MIS.modules.cart_items.CartItemsEntity;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends DataTablesRepository<CartItemsEntity,Integer>, CartItemRepositoryCustom {
}
