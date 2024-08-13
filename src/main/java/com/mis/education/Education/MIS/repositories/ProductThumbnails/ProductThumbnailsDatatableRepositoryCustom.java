package com.mis.education.Education.MIS.repositories.ProductThumbnails;

import com.mis.education.Education.MIS.modules.products.entity.ProductsEntity;
import com.mis.education.Education.MIS.modules.products.entity.ProductsThumbnail;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ProductThumbnailsDatatableRepositoryCustom {
    List<ProductsThumbnail> getProductThumbnailsViaId(Integer productId);

    void deleteRow(Integer id);


}
