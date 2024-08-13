package com.mis.education.Education.MIS.repositories.products;

import com.mis.education.Education.MIS.modules.products.entity.ProductsEntity;
import com.mis.education.Education.MIS.modules.user.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductsDatatableRepository extends DataTablesRepository<ProductsEntity,Long>, ProductsDatatableRepositoryCustom {

    @Query(value = "SELECT * FROM mst_products e WHERE e.active = true", nativeQuery = true)
    Page<ProductsEntity> findByIsActiveTrue(Pageable pageable);
}
