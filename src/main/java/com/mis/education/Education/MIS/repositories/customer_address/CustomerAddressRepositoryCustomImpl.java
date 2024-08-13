package com.mis.education.Education.MIS.repositories.customer_address;

import com.mis.education.Education.MIS.modules.customer_address.CustomerAddressEntity;
import com.mis.education.Education.MIS.modules.states.StatesMaster;
import com.mis.education.Education.MIS.modules.wishlist.WishlistEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerAddressRepositoryCustomImpl implements CustomerAddressRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public List<CustomerAddressEntity> getAddressByUSerId(Integer userId) {

            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<CustomerAddressEntity> cq = cb.createQuery(CustomerAddressEntity.class);
            Root<CustomerAddressEntity> book = cq.from(CustomerAddressEntity.class);
            Predicate isActive_ = cb.equal(book.get("active"), true);
            Predicate userId_ = cb.equal(book.get("userId").get("userId"), userId);
            cq.where(isActive_,userId_);
            TypedQuery<CustomerAddressEntity> query =  entityManager.createQuery(cq);
            return query.getResultList();

    }

    @Override
    public CustomerAddressEntity getAddressByAddressId(Integer addressId) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<CustomerAddressEntity> cq = cb.createQuery(CustomerAddressEntity.class);
        Root<CustomerAddressEntity> book = cq.from(CustomerAddressEntity.class);
        Predicate isActive_ = cb.equal(book.get("active"), true);
        Predicate addressId_ = cb.equal(book.get("addressId"), addressId);
        cq.where(isActive_,addressId_);
        TypedQuery<CustomerAddressEntity> query =  entityManager.createQuery(cq);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            // If no address is found, return an empty entity or null
            return null; // or return new CustomerAddressEntity(); if you have an appropriate constructor
        }

    }

    @Transactional
    @Override
    public void deleteRow(Integer id) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaDelete<CustomerAddressEntity> delete = cb.createCriteriaDelete(CustomerAddressEntity.class);
        Root<CustomerAddressEntity> root = delete.from(CustomerAddressEntity.class);
        Predicate predicate = cb.equal(root.get("addressId"), id);
        delete.where(predicate);
        entityManager.createQuery(delete).executeUpdate();

    }
}
