package com.mis.education.Education.MIS.repositories.wishlist;

import com.mis.education.Education.MIS.modules.products.entity.ProductsEntity;
import com.mis.education.Education.MIS.modules.wishlist.WishlistEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface WishlistDatatableRepository extends DataTablesRepository<WishlistEntity,Integer>, WishlistDatatableRepositoryCustom {


}
