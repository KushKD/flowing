package com.mis.education.Education.MIS.repositories.roles;

import com.mis.education.Education.MIS.modules.role.entity.RolesEntity;
import com.mis.education.Education.MIS.modules.role.modal.RolesModal;
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
public class RolesRepositoryCustomImpl implements RolesRepositoryCustom{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<RolesModal> getRoles() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<RolesModal> cq = cb.createQuery(RolesModal.class);
        Root<RolesEntity> book = cq.from(RolesEntity.class);
        Predicate isActive_ = cb.equal(book.get("active"), true);
        cq.where(isActive_);
        cq.multiselect( book.get("roleId"), book.get("roleName")).distinct(true);
        TypedQuery<RolesModal> query =  entityManager.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public Boolean checkRole(String rolenmae) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<RolesEntity> book = cq.from(RolesEntity.class);
        Predicate isActive_ = cb.equal(book.get("active"), true);
        Predicate role_name = cb.equal(book.get("roleName"), rolenmae);
        cq.where(isActive_,role_name);
        cq.select(cb.count(book)).where(isActive_,role_name) ;
        TypedQuery<Long> query =  entityManager.createQuery(cq);
        if(Math.toIntExact(entityManager.createQuery(cq).getSingleResult())>0){
            return true;
        }else{
            return false;
        }
    }



    @Override
    public List<RolesModal> getRoleVendor() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<RolesModal> cq = cb.createQuery(RolesModal.class);
        Root<RolesEntity> book = cq.from(RolesEntity.class);
        Predicate isActive_ = cb.equal(book.get("active"), true);
        Predicate role_name = cb.equal(book.get("roleName"), "Vendor");
        cq.where(isActive_,role_name);
        cq.multiselect(book.get("roleId"), book.get("roleName")).distinct(true);
        TypedQuery<RolesModal> query =  entityManager.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public RolesEntity getRoleViaId(Integer roleId) throws Exception {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<RolesEntity> cq = cb.createQuery(RolesEntity.class);
        Root<RolesEntity> book = cq.from(RolesEntity.class);
        Predicate role_id = cb.equal(book.get("roleId"), roleId);
        cq.where(role_id);
        TypedQuery<RolesEntity> query =  entityManager.createQuery(cq);
        return query.getResultList().get(0);
    }
}
