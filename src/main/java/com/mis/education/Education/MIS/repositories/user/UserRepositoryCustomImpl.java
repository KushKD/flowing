package com.mis.education.Education.MIS.repositories.user;

import com.mis.education.Education.MIS.modules.order.OrdersEntity;
import com.mis.education.Education.MIS.modules.user.modal.LoggedInUserLocationSession;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import com.mis.education.Education.MIS.modules.user.entity.UserEntity;

@Service
public class UserRepositoryCustomImpl implements UserRepositoryCustom{

    @PersistenceContext
    EntityManager entityManager;


    @Override
//    public List<LoggedInUserLocationSession> getUserGeoData(String username_) {
//
//        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//        CriteriaQuery<LoggedInUserLocationSession> cq = cb.createQuery(LoggedInUserLocationSession.class);
//        Root<UserEntity> book = cq.from(UserEntity.class);
//        Predicate isActive_ = cb.equal(book.get("active"), true);
//        Predicate isDeleted_ = cb.equal(book.get("isDeleted"), false);
//        Predicate username = cb.equal(book.get("username"), username_);
//        cq.where(isActive_,isDeleted_,username);
//        cq.multiselect(book.get("state").<Integer> get("stateID"),
//                book.get("district").<Integer>get("districtId"),
//                book.get("block").<Integer>get("districtId"),
//                book.get("userId")).distinct(true);
//        TypedQuery<LoggedInUserLocationSession> query =  entityManager.createQuery(cq);
//        return query.getResultList();
//
//    }


    public List<UserEntity> getUserGeoData(String username_) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserEntity> cq = cb.createQuery(UserEntity.class);
        Root<UserEntity> book = cq.from(UserEntity.class);
        Predicate isActive_ = cb.equal(book.get("active"), true);
        Predicate isDeleted_ = cb.equal(book.get("isDeleted"), false);
        Predicate username = cb.equal(book.get("username"), username_);
        cq.where(isActive_,isDeleted_,username);
        TypedQuery<UserEntity> query =  entityManager.createQuery(cq);
        return query.getResultList();

    }




    @Override
    public UserEntity findByMobileNumber(Long mobile) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserEntity> cq = cb.createQuery(UserEntity.class);
        Root<UserEntity> book = cq.from(UserEntity.class);
        Predicate isActive_ = cb.equal(book.get("active"), true);
        Predicate isDeleted_ = cb.equal(book.get("isDeleted"), false);
        Predicate mobile_ = cb.equal(book.get("mobileNumber"), mobile);
        cq.where(isActive_,isDeleted_,mobile_);
        TypedQuery<UserEntity> query =  entityManager.createQuery(cq);
        return query.getSingleResult();
    }

    @Override
    public UserEntity getUserDetails(Long mobile) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserEntity> cq = cb.createQuery(UserEntity.class);
        Root<UserEntity> book = cq.from(UserEntity.class);
        Predicate isActive_ = cb.equal(book.get("active"), true);
        Predicate isDeleted_ = cb.equal(book.get("isDeleted"), false);
        Predicate mobile_ = cb.equal(book.get("mobileNumber"), mobile);
        cq.where(isActive_,isDeleted_,mobile_);
        TypedQuery<UserEntity> query =  entityManager.createQuery(cq);
        return query.getSingleResult();
    }

    @Override
    public Integer getCompanyId(String username_) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Integer> cq = cb.createQuery(Integer.class);
        Root<UserEntity> book = cq.from(UserEntity.class);
        Predicate isActive_ = cb.equal(book.get("active"), true);
        Predicate isDeleted_ = cb.equal(book.get("isDeleted"), false);
        Predicate username = cb.equal(book.get("username"), username_);
        cq.where(isActive_, isDeleted_, username);
        cq.select(book.get("company").get("companyId")); // Assuming 'companyId' is the name of the column holding the company ID
        TypedQuery<Integer> query = entityManager.createQuery(cq);
        return query.getSingleResult();
    }

    @Override
    public Long getTotalCustomers() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<UserEntity> book = cq.from(UserEntity.class);
        Predicate isActive_ = cb.equal(book.get("active"), true);
        cq.select(cb.count(book)).where(isActive_);
        return entityManager.createQuery(cq).getSingleResult();
    }




}
