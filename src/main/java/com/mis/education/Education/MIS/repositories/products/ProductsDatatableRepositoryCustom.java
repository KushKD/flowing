package com.mis.education.Education.MIS.repositories.products;

import com.mis.education.Education.MIS.modules.products.entity.ProductsEntity;
import com.mis.education.Education.MIS.modules.user.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ProductsDatatableRepositoryCustom {

    List<ProductsEntity> checkProductName(String productName);
    ProductsEntity getProductViaId(Integer productId);

    Long getTotalProducts();


    ;
}
