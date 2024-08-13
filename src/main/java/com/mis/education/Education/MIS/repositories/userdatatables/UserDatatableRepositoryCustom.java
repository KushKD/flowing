package com.mis.education.Education.MIS.repositories.userdatatables;

import com.mis.education.Education.MIS.modules.user.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface UserDatatableRepositoryCustom {
    List<UserEntity> getExcelReport(String state, String district, String block, String edu_block, String constituency, String gender, String subcaste, String caste, String company, String sector, String school, String teacherType, String qualification, String pro_qualification);

    List<UserEntity> getExcelReportTeacerVTP(String state, String district,String block,String educationblock, String gender, String subcaste, String caste, String company, String sector, String phase);
}
