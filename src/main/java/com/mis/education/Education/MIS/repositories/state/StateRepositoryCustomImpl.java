package com.mis.education.Education.MIS.repositories.state;


import com.mis.education.Education.MIS.modules.states.StatesMaster;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class StateRepositoryCustomImpl implements StateRepositoryCustom{


        @PersistenceContext
        private EntityManager entityManager;

        @Override
        public List<StatesMaster> getAllStates() {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<StatesMaster> cq = cb.createQuery(StatesMaster.class);
            Root<StatesMaster> book = cq.from(StatesMaster.class);
            Predicate isActive_ = cb.equal(book.get("active"), true);
            Predicate isDeleted_ = cb.equal(book.get("deleted"), false);
            Predicate country = cb.equal(book.get("countryId"), 1);
            cq.where(isActive_,isDeleted_,country);
            TypedQuery<StatesMaster> query =  entityManager.createQuery(cq);
            return query.getResultList();
        }

//        @Override
//        public List<StatesMaster> getCompleteListStates() {
//            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//            CriteriaQuery<StatesMaster> cq = cb.createQuery(StatesMaster.class);
//            Root<StatesMaster> book = cq.from(StatesMaster.class);
//            TypedQuery<StatesMaster> query =  entityManager.createQuery(cq);
//            return query.getResultList();
//        }

//        @Override
//        public StatesMaster getStateViaStateId(Integer stateID) {
//            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//            CriteriaQuery<StatesMaster> cq = cb.createQuery(StatesMaster.class);
//            Root<StatesMaster> book = cq.from(StatesMaster.class);
//            Predicate stateId = cb.equal(book.get("stateID"), stateID);
//            cq.where(stateId);
//            TypedQuery<StatesMaster> query =  entityManager.createQuery(cq);
//            return query.getResultList().get(0);
//        }

//        @Override
//        public List<StateModal> getHimachalState() {
//            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//            CriteriaQuery<StateModal> cq = cb.createQuery(StateModal.class);
//            Root<StatesMaster> book = cq.from(StatesMaster.class);
//            Predicate isActive_ = cb.equal(book.get("active"), true);
//            Predicate isDeleted_ = cb.equal(book.get("deleted"), false);
//            Predicate stateId = cb.equal(book.get("stateID"), Constants.stateID);
//            cq.where(isActive_,isDeleted_,stateId);
//            cq.multiselect(book.get("stateID"), book.get("stateName")).distinct(true);
//            TypedQuery<StateModal> query =  entityManager.createQuery(cq);
//            return query.getResultList();
//        }

//        @Override
//        public Integer stateCount(String StateName) {
//            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//            CriteriaQuery<Long> cq = cb.createQuery(Long.class);
//            Root<StatesMaster> book = cq.from(StatesMaster.class);
//            Predicate isActive_ = cb.equal(book.get("active"), true);
//            Predicate isDeleted_ = cb.equal(book.get("deleted"), false);
//            Predicate stateName = cb.equal(book.get("stateName"), StateName);
//            cq.where(isActive_,isDeleted_,stateName);
//            cq.select(cb.count(book)).where(isActive_,isDeleted_,stateName);
//            return Math.toIntExact(entityManager.createQuery(cq).getSingleResult());
//        }


    }

