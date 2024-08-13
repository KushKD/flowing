package com.mis.education.Education.MIS.repositories.cart_items;

import com.mis.education.Education.MIS.modules.cart_items.CartItemsEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CartItemRepositoryCustom {

    boolean deleteItemById(int id);

    List<CartItemsEntity> getCartItemViaId(Long userId, Integer cartId);

    List<CartItemsEntity> getCartItemViaId(Long userId, Integer cartId, Long productId);


}
