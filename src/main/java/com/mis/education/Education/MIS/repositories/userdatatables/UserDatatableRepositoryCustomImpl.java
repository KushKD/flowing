package com.mis.education.Education.MIS.repositories.userdatatables;

import com.mis.education.Education.MIS.modules.user.entity.UserEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserDatatableRepositoryCustomImpl implements UserDatatableRepositoryCustom{

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public List<UserEntity> getExcelReport(String state, String district, String block, String edu_block, String constituency, String gender, String subcaste, String caste, String company, String sector, String school, String teacherType, String qualification, String pro_qualification) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserEntity> cq = cb.createQuery(UserEntity.class);
        Root<UserEntity> book = cq.from(UserEntity.class);

        List<Predicate> predicates = new ArrayList<>();
        Predicate state_, district_, block_, edu_block_, constituency_;
        Predicate gender_, class__, section_, subcaste_, caste_, economic_status_,cwsnstatus_, hpbonafied_,singlegirl_,
                disability_, teacherType_ ,qualification_, proqualification_, Company_, Sector_, school_;



        if (state != null && !state.isEmpty()) {
            state_ = cb.equal(book.get("stateId").get("stateID"), Integer.parseInt(state));
            predicates.add(state_);
        }

        if (district != null && !district.isEmpty()) {
            district_ = cb.equal(book.get("districtId").get("districtId"), Integer.parseInt(district));
            predicates.add(district_);
        }

        if (block != null && !block.isEmpty()) {
            block_ = cb.equal(book.get("blockId").get("districtId"), Integer.parseInt(block));
            predicates.add(block_);
        }

        if (edu_block != null && !edu_block.isEmpty()) {
            edu_block_ = cb.equal(book.get("edublock").get("districtId"), Integer.parseInt(edu_block));
            predicates.add(edu_block_);
        }

        if (constituency != null && !constituency.isEmpty()) {
            constituency_ = cb.equal(book.get("ac").get("acId"), Integer.parseInt(constituency));
            predicates.add(constituency_);
        }

        if (school != null && !school.isEmpty()) {
            school_ = cb.equal(book.get("schoolId").get("schoolId"), Integer.parseInt(school));
            predicates.add(school_);
        }

        if (teacherType != null && !teacherType.isEmpty()) {
            teacherType_ = cb.equal(book.get("ttype_id").get("ttypeId"), Integer.parseInt(teacherType));
            predicates.add(teacherType_);
        }
//            if (qualification != null && !qualification.isEmpty()) {
//                qualification_ = cb.equal(book.get("genderId").get("genderId"), Integer.parseInt(qualification));
//                predicates.add(qualification_);
//            }
//            if (pro_qualification != null && !pro_qualification.isEmpty()) {
//                proqualification_ = cb.equal(book.get("genderId").get("genderId"), Integer.parseInt(pro_qualification));
//                predicates.add(proqualification_);
//            }
        if (gender != null && !gender.isEmpty()) {
            gender_ = cb.equal(book.get("genderID").get("genderId"), Integer.parseInt(gender));
            predicates.add(gender_);
        }


//            if (Company != null && !Company.isEmpty()) {
//                Company_ = cb.equal(book.get("companyId").get("companyId"), Integer.parseInt(Company));
//                predicates.add(Company_);
//            }
//            if (Sector != null && !Sector.isEmpty()) {
//                Sector_ = cb.equal(book.get("sectorId").get("sectorId"), Integer.parseInt(Sector));
//                predicates.add(Sector_);
//            }
//
//            if (subcaste != null && !subcaste.isEmpty()) {
//                subcaste_ = cb.equal(book.get("religion").get("religionId"), Integer.parseInt(subcaste));
//                predicates.add(subcaste_);
//            }
//
//            if (caste != null && !caste.isEmpty()) {
//                caste_ = cb.equal(book.get("casteId").get("casteId"), Integer.parseInt(caste));
//                predicates.add(caste_);
//            }


        cq.where(predicates.toArray(new Predicate[0]));
        TypedQuery<UserEntity> queryq =  entityManager.createQuery(cq);
        return queryq.getResultList();
    }

    @Override
    public List<UserEntity> getExcelReportTeacerVTP(String state, String district, String block, String edu_block, String gender, String subcaste, String caste, String company, String sector, String phase) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserEntity> cq = cb.createQuery(UserEntity.class);
        Root<UserEntity> book = cq.from(UserEntity.class);

        List<Predicate> predicates = new ArrayList<>();
        Predicate state_, district_, block_, edu_block_, constituency_ ,gender_,  subcaste_, caste_, Company_, Sector_, school_, phase_;


        state_ = cb.equal(book.get("stateId").get("stateID"), Integer.parseInt(state));
        predicates.add(state_);

        district_ = cb.equal(book.get("districtId").get("districtId"), Integer.parseInt(district));
        predicates.add(district_);

        block_ = cb.equal(book.get("blockId").get("districtId"), Integer.parseInt(block));
        predicates.add(block_);

        edu_block_ = cb.equal(book.get("edublock").get("districtId"), Integer.parseInt(edu_block));
        predicates.add(edu_block_);
//
//


        if (gender != null && !gender.isEmpty()) {
            gender_ = cb.equal(book.get("genderID").get("genderId"), Integer.parseInt(gender));
            predicates.add(gender_);
        }

        Company_ = cb.equal(book.get("company").get("companyId"),Integer.parseInt(company) );
        predicates.add(Company_);

        if (sector != null && !sector.isEmpty()) {
            Sector_ = cb.equal(book.get("sector").get("sectorId"), Integer.parseInt(sector));
            predicates.add(Sector_);
        }

        if (subcaste != null && !subcaste.isEmpty()) {
            subcaste_ = cb.equal(book.get("religionId").get("religionId"), Integer.parseInt(subcaste));
            predicates.add(subcaste_);
        }

        if (caste != null && !caste.isEmpty()) {
            caste_ = cb.equal(book.get("casteId").get("casteId"), Integer.parseInt(caste));
            predicates.add(caste_);
        }

        if (phase != null && !phase.isEmpty()) {
            phase_ = cb.equal(book.get("phaseId").get("phaseId"), Integer.parseInt(phase));
            predicates.add(phase_);
        }


        cq.where(predicates.toArray(new Predicate[0]));
        TypedQuery<UserEntity> queryq =  entityManager.createQuery(cq);
        return queryq.getResultList();
    }
}
