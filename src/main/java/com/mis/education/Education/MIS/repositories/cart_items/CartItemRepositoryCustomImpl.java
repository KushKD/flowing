package com.mis.education.Education.MIS.repositories.cart_items;

import com.mis.education.Education.MIS.modules.cart.CartEntity;
import com.mis.education.Education.MIS.modules.cart_items.CartItemsEntity;
import com.mis.education.Education.MIS.modules.products.entity.ProductsThumbnail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class CartItemRepositoryCustomImpl implements CartItemRepositoryCustom{


    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @Override
    public boolean deleteItemById(int id) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaDelete<CartItemsEntity> criteriaDelete = criteriaBuilder.createCriteriaDelete(CartItemsEntity.class);
        Root<CartItemsEntity> root = criteriaDelete.from(CartItemsEntity.class);
        Predicate productId = criteriaBuilder.equal(root.get("productsEntity").get("productId"), id);
        criteriaDelete.where(productId);
        int deletedCount = entityManager.createQuery(criteriaDelete).executeUpdate();
        return deletedCount > 0;
    }

    @Override
    public List<CartItemsEntity> getCartItemViaId(Long userId, Integer cartId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<CartItemsEntity> cq = cb.createQuery(CartItemsEntity.class);
        Root<CartItemsEntity> book = cq.from(CartItemsEntity.class);
        Predicate userId_ = cb.equal(book.get("userId"), userId);
        Predicate cart_ID= cb.equal(book.get("cartId"), userId);
        cq.where(userId_, cart_ID);
        TypedQuery<CartItemsEntity> query =  entityManager.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public List<CartItemsEntity> getCartItemViaId(Long userId, Integer cartId, Long productId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<CartItemsEntity> cq = cb.createQuery(CartItemsEntity.class);
        Root<CartItemsEntity> book = cq.from(CartItemsEntity.class);
        Predicate userId_ = cb.equal(book.get("userId"), userId);
        Predicate cart_ID= cb.equal(book.get("cartId"), cartId);
        Predicate product_ID= cb.equal(book.get("productsEntity").get("productId"), productId);
        cq.where(userId_, cart_ID, product_ID);
        TypedQuery<CartItemsEntity> query =  entityManager.createQuery(cq);
        return query.getResultList();
    }


}
