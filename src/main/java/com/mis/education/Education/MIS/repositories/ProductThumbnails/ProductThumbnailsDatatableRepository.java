package com.mis.education.Education.MIS.repositories.ProductThumbnails;

import com.mis.education.Education.MIS.modules.products.entity.ProductsEntity;
import com.mis.education.Education.MIS.modules.products.entity.ProductsThumbnail;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductThumbnailsDatatableRepository extends DataTablesRepository<ProductsThumbnail,Long>, ProductThumbnailsDatatableRepositoryCustom {


}
