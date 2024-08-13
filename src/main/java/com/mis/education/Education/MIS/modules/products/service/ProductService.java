package com.mis.education.Education.MIS.modules.products.service;

import com.mis.education.Education.MIS.modules.products.entity.ProductsEntity;
import com.mis.education.Education.MIS.repositories.products.ProductsDatatableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductsDatatableRepository productsDatatableRepository;

    public Page<ProductsEntity> getPaginatedData(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return productsDatatableRepository.findByIsActiveTrue(pageable);
    }

    public long getTotalRecords() {
        return productsDatatableRepository.count();
    }
}
