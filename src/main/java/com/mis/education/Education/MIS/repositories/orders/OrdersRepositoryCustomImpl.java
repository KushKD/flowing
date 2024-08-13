package com.mis.education.Education.MIS.repositories.orders;

import com.mis.education.Education.MIS.modules.cart.CartEntity;
import com.mis.education.Education.MIS.modules.order.OrdersEntity;
import com.mis.education.Education.MIS.utilities.Constants;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Service
public class OrdersRepositoryCustomImpl implements OrdersRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public OrdersEntity findOrderByOrderId(String razorpay_order_id) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<OrdersEntity> cq = cb.createQuery(OrdersEntity.class);
        Root<OrdersEntity> book = cq.from(OrdersEntity.class);
        Predicate userId_ = cb.equal(book.get("orderId"), razorpay_order_id);
        cq.where(userId_);
        TypedQuery<OrdersEntity> query =  entityManager.createQuery(cq);
        return query.getSingleResult();
    }

    @Override
    public OrdersEntity findOrderById(Integer id) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<OrdersEntity> cq = cb.createQuery(OrdersEntity.class);
        Root<OrdersEntity> book = cq.from(OrdersEntity.class);
        Predicate userId_ = cb.equal(book.get("id"), id);
        cq.where(userId_);
        TypedQuery<OrdersEntity> query =  entityManager.createQuery(cq);
        return query.getSingleResult();
    }


    @Override
    public Integer getCompletedOrders() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<OrdersEntity> book = cq.from(OrdersEntity.class);
        Predicate isActive_ = cb.equal(book.get("status"), "completed");
        cq.select(cb.count(book)).where(isActive_);
        return Math.toIntExact(entityManager.createQuery(cq).getSingleResult());
    }

    @Override
    public Integer getCreatedOrders() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<OrdersEntity> book = cq.from(OrdersEntity.class);
        Predicate isActive_ = cb.equal(book.get("status"), "created");
        cq.select(cb.count(book)).where(isActive_);
        return Math.toIntExact(entityManager.createQuery(cq).getSingleResult());
    }

    @Override
    public Integer getCompletedOrdersViaUserID(Integer UserID) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<OrdersEntity> book = cq.from(OrdersEntity.class);
        Predicate isActive_ = cb.equal(book.get("status"), "completed");
        Predicate userId = cb.equal(book.get("userId").get("userId"), UserID);
        cq.select(cb.count(book)).where(isActive_,userId);
        return Math.toIntExact(entityManager.createQuery(cq).getSingleResult());
    }

    @Override
    public Integer getCreatedOrdersViaUserID(Integer UserId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<OrdersEntity> book = cq.from(OrdersEntity.class);
        Predicate isActive_ = cb.equal(book.get("status"), "created");
        Predicate userId = cb.equal(book.get("userId").get("userId"), UserId);
        cq.select(cb.count(book)).where(isActive_,userId);
        return Math.toIntExact(entityManager.createQuery(cq).getSingleResult());

    }

    @Override
    public Double getTotalPaymentsReceived() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Double> cq = cb.createQuery(Double.class);
        Root<OrdersEntity> book = cq.from(OrdersEntity.class);
        Predicate isActive_ = cb.equal(book.get("status"), "completed");
        cq.select(cb.sum(book.get("amount"))).where(isActive_);
        return entityManager.createQuery(cq).getSingleResult();
    }
}
