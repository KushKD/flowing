package com.mis.education.Education.MIS.repositories.cart;

import com.mis.education.Education.MIS.modules.cart.CartEntity;
import com.mis.education.Education.MIS.modules.wishlist.WishlistEntity;
import com.mis.education.Education.MIS.utilities.Constants;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepositoryCustom  {

    List<CartEntity> getCartItemViaId(Long userId, String active);
    CartEntity getCartViaId(Long userId);


    //boolean deleteItemById(int id);
}
