package com.mis.education.Education.MIS.repositories.ProductThumbnails;

import com.mis.education.Education.MIS.modules.cart.CartEntity;
import com.mis.education.Education.MIS.modules.products.entity.ProductsEntity;
import com.mis.education.Education.MIS.modules.products.entity.ProductsThumbnail;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductThumbnailsDatatableRepositoryCustomImpl implements ProductThumbnailsDatatableRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public List<ProductsThumbnail> getProductThumbnailsViaId(Integer productId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<ProductsThumbnail> cq = cb.createQuery(ProductsThumbnail.class);
        Root<ProductsThumbnail> book = cq.from(ProductsThumbnail.class);
        Predicate role_id = cb.equal(book.get("productId"), productId);
        cq.where(role_id);
        TypedQuery<ProductsThumbnail> query =  entityManager.createQuery(cq);
        return query.getResultList();
    }



    @Transactional
    public void deleteRow(Integer productId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaDelete<ProductsThumbnail> delete = cb.createCriteriaDelete(ProductsThumbnail.class);
        Root<ProductsThumbnail> root = delete.from(ProductsThumbnail.class);
        Predicate predicate = cb.equal(root.get("thumbnailId"), productId);
        delete.where(predicate);
        entityManager.createQuery(delete).executeUpdate();
    }




}
