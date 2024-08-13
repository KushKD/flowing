package com.mis.education.Education.MIS.repositories.cart;

import com.mis.education.Education.MIS.modules.cart.CartEntity;
import com.mis.education.Education.MIS.modules.wishlist.WishlistEntity;
import com.mis.education.Education.MIS.utilities.Constants;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.lang.invoke.ConstantCallSite;
import java.util.List;

@Service
public class CartRepositoryCustomImpl implements CartRepositoryCustom {


    @PersistenceContext
    EntityManager entityManager;


    @Override
    public List<CartEntity> getCartItemViaId(Long userId, String cartActive) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<CartEntity> cq = cb.createQuery(CartEntity.class);
        Root<CartEntity> book = cq.from(CartEntity.class);
        Predicate userId_ = cb.equal(book.get("userId").get("userId"), userId);
        Predicate active = cb.equal(book.get("active"), true);
        Predicate cartActive_ = cb.equal(book.get("status"), Constants.CART_ACTIVE);
        cq.where(userId_, active, cartActive_);
        TypedQuery<CartEntity> query =  entityManager.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public CartEntity getCartViaId(Long userId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<CartEntity> cq = cb.createQuery(CartEntity.class);
        Root<CartEntity> book = cq.from(CartEntity.class);
        Predicate userId_ = cb.equal(book.get("userId").get("userId"), userId);
        Predicate active = cb.equal(book.get("active"), true);
        Predicate cartActive_ = cb.equal(book.get("status"), Constants.CART_ACTIVE);
        cq.where(userId_, active, cartActive_);
        TypedQuery<CartEntity> query =  entityManager.createQuery(cq);
        return query.getSingleResult();
    }

//    @Override
//    public List<CartEntity> getCartItemViaId(Long userId) {
//        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//        CriteriaQuery<CartEntity> cq = cb.createQuery(CartEntity.class);
//        Root<CartEntity> book = cq.from(CartEntity.class);
//        Predicate userId_ = cb.equal(book.get("userId").get("userId"), userId);
//        Predicate active = cb.equal(book.get("active"), true);
//        cq.where(userId_, active);
//        TypedQuery<CartEntity> query =  entityManager.createQuery(cq);
//        return query.getResultList();
//    }
//



}
