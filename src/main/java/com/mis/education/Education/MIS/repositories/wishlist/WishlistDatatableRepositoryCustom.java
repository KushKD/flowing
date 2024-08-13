package com.mis.education.Education.MIS.repositories.wishlist;

import com.mis.education.Education.MIS.modules.products.entity.ProductsEntity;
import com.mis.education.Education.MIS.modules.wishlist.WishlistEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishlistDatatableRepositoryCustom {


    List<WishlistEntity> getProductViaId(Integer productId , Long userId);

    void deleteRow(Integer productId);


}
