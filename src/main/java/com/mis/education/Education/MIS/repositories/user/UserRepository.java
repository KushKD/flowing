package com.mis.education.Education.MIS.repositories.user;

import com.mis.education.Education.MIS.modules.user.entity.UserEntity;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.annotation.Nullable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;


@Repository
public interface UserRepository extends DataTablesRepository<UserEntity,Long>, UserRepositoryCustom{

    UserEntity findByUsername(String username);


    @Query(value="SELECT u.*, urm.role_id, r.role_name FROM users as u INNER JOIN user_role_mapping as urm on urm.user_id = u.user_id INNER JOIN roles as r on r.role_id = urm.role_id WHERE u.user_id =:userId ", nativeQuery = true)
    List<Object[]> getSpecificUserViaUserRoleId(@Param("userId")  Integer userId);


    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE users SET firstname =:firstname, lastname =:lastname, username =:username, password =:password, mobile_number =:mobileNumber, email =:email, gender_id = :genderId, state_id =:stateId, district_id =:districtId, block_id =:blockId, p_address =:address, educationalblock_id =:educationalblock_id, ac_id = :acId, school_id =:schoolId, caste_id =:caste, religion_id =:religion, employee_code=:employee, ttype_id=:ttype, aadhaar=:aadhaar, proqualification_id=:proqualification, qualification_id =:qualification, photo =:photo, company_id =:company, sector_id =:sector, posting_id =:posting, phase_id =:phase, dateof_joininglast=:dojl, dateof_joining=:dojf,  active =:active, isdeleted =:deleted, lastmodifieddate =:lastmodifieddate, salarycode =:salarycode , whatsapp_number =:whatsapp_number, dob =:dob, c_address =:c_address, bg_id =:bg_id WHERE user_id =:userId" , nativeQuery = true)
    int updateUser(        @Param("firstname") String firstname,
                           @Param("lastname") String lastname,
                           @Param("username") String username,
                           @Param("password") String password,
                           @Param("mobileNumber") BigInteger mobileNumber,
                           @Param("email") String email,
                           @Param("genderId") Integer genderId,
                           @Param("stateId") Integer stateId,
                           @Param("districtId") Integer districtId,
                           @Param("blockId") Integer blockId,
                           @Param("address") String address,
                           @Param("educationalblock_id") Integer educationalblock_id,
                           @Param("acId") Integer ac_id,
                           @Param("schoolId") Integer school_id,
                           @Param("caste") Integer caste_id,
                           @Param("religion") Integer religion_id,
                           @Param("employee") String employee_code,
                           @Param("ttype") Integer ttype_id,
                           @Param("aadhaar") String aadhaar,
                           @Param("proqualification") Integer proqualification_id,
                           @Param("qualification") Integer qualification_id,
                           @Param("active") Boolean active,
                           @Param("deleted") Boolean isdeleted,
                           @Param("lastmodifieddate") Date lastmodifieddate,
                           @Param("userId") Integer userId,


                           @Nullable @Param(("bg_id")) Integer bg_id

    );



    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE users SET firstname =:firstname, lastname =:lastname, username =:username, password =:password, mobile_number =:mobileNumber, email =:email, gender_id = :genderId, state_id =:stateId, district_id =:districtId, block_id =:blockId, p_address =:address, educationalblock_id =:educationalblock_id, ac_id = :acId, school_id =:schoolId, caste_id =:caste, religion_id =:religion, employee_code=:employee, ttype_id=:ttype, aadhaar=:aadhaar, proqualification_id=:proqualification, qualification_id =:qualification, photo =:photo, company_id =:company, sector_id =:sector, posting_id =null, phase_id =:phase, dateof_joininglast=null, dateof_joining=null,  active =:active, isdeleted =:deleted, lastmodifieddate =:lastmodifieddate, salarycode =:salarycode , whatsapp_number =:whatsapp_number, dob =:dob, c_address =:c_address, bg_id =:bg_id WHERE user_id =:userId" , nativeQuery = true)
    int updateUserVTP(        @Param("firstname") String firstname,
                           @Param("lastname") String lastname,
                           @Param("username") String username,
                           @Param("password") String password,
                           @Param("mobileNumber") BigInteger mobileNumber,
                           @Param("email") String email,
                           @Param("genderId") Integer genderId,
                           @Param("stateId") Integer stateId,
                           @Param("districtId") Integer districtId,
                           @Param("blockId") Integer blockId,
                           @Param("address") String address,
                           @Param("educationalblock_id") Integer educationalblock_id,
                           @Param("acId") Integer ac_id,
                           @Param("schoolId") Integer school_id,
                           @Param("caste") Integer caste_id,
                           @Param("religion") Integer religion_id,
                           @Param("employee") String employee_code,
                           @Param("ttype") Integer ttype_id,
                           @Param("aadhaar") String aadhaar,
                           @Param("proqualification") Integer proqualification_id,
                           @Param("qualification") Integer qualification_id,
                           @Param("active") Boolean active,
                           @Param("deleted") Boolean isdeleted,
                           @Param("lastmodifieddate") Date lastmodifieddate,
                           @Param("userId") Integer userId,
                           @Param(("photo")) String photo,
                           @Nullable @Param(("company")) Integer company,
                           @Nullable @Param(("sector")) Integer sector,
                           @Nullable @Param(("phase")) Integer phase,
                           @Nullable @Param(("salarycode")) String salarycode,
                          @Nullable @Param(("dob")) String dob,
                          @Nullable @Param(("c_address")) String c_address,
                          @Nullable @Param(("whatsapp_number")) String whatsapp_number,
                          @Nullable @Param(("bg_id")) Integer bg_id

    );


    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE users SET firstname =:firstname, lastname =:lastname, username =:username, password =:password, mobile_number =:mobileNumber, email =:email, gender_id = :genderId, state_id =:stateId, district_id =:districtId, block_id =:blockId, p_address =:address, educationalblock_id =:educationalblock_id, ac_id = :acId, school_id =:schoolId, caste_id =:caste, religion_id =:religion, employee_code=:employee, ttype_id=:ttype, aadhaar=:aadhaar, proqualification_id=:proqualification, qualification_id =:qualification, photo =:photo, company_id =null, sector_id =null, posting_id =null, phase_id =null, dateof_joininglast=null, dateof_joining=null,  active =:active, isdeleted =:deleted, lastmodifieddate =:lastmodifieddate , salarycode =:salarycode , whatsapp_number =:whatsapp_number, dob =:dob, c_address =:c_address, bg_id =:bg_id WHERE user_id =:userId" , nativeQuery = true)
    int updateUserAllOthers(        @Param("firstname") String firstname,
                              @Param("lastname") String lastname,
                              @Param("username") String username,
                              @Param("password") String password,
                              @Param("mobileNumber") BigInteger mobileNumber,
                              @Param("email") String email,
                              @Param("genderId") Integer genderId,
                              @Param("stateId") Integer stateId,
                              @Param("districtId") Integer districtId,
                              @Param("blockId") Integer blockId,
                              @Param("address") String address,
                              @Param("educationalblock_id") Integer educationalblock_id,
                              @Param("acId") Integer ac_id,
                              @Param("schoolId") Integer school_id,
                              @Param("caste") Integer caste_id,
                              @Param("religion") Integer religion_id,
                              @Param("employee") String employee_code,
                              @Param("ttype") Integer ttype_id,
                              @Param("aadhaar") String aadhaar,
                              @Param("proqualification") Integer proqualification_id,
                              @Param("qualification") Integer qualification_id,
                              @Param("active") Boolean active,
                              @Param("deleted") Boolean isdeleted,
                              @Param("lastmodifieddate") Date lastmodifieddate,
                              @Param("userId") Integer userId,
                              @Param(("photo")) String photo,
                                @Nullable @Param(("salarycode")) String salarycode,
                                @Nullable @Param(("dob")) String dob,
                                @Nullable @Param(("c_address")) String c_address,
                                @Nullable @Param(("whatsapp_number")) String whatsapp_number,
                                @Nullable @Param(("bg_id")) Integer bg_id

    );

    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE user_role_mapping SET role_id =:roleId WHERE user_id =:userId AND role_id =:oldRoleId" , nativeQuery = true)
    int updateRole(@Param("roleId") Integer roleId,
                   @Param("userId") Integer userId,
                   @Param("oldRoleId") Integer oldRoleId);
}
