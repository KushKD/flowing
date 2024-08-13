package com.mis.education.Education.MIS.modules.user.modal;



import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
import java.math.BigInteger;

public class UsersDetails implements Serializable {

    private Integer userId;
    private String firstName;
    private String lastName;
    private String username;
    private BigInteger mobileNumber;
    private Integer state;
    private Integer district;
    private Integer block;
    private Integer educationalBlock;
    private Integer constituency;

    private Integer school;
    private String address;
    private String email;
    private Integer gender;
    private Integer roleId;

    private String employeeCode;
    private String dojFirst;
    private String dojLPresentSchool;

    private Integer caste;
    private Integer subcaste;

    private Integer qualification;

    private Integer pro_qualification;

    private String aadhaar;

    private Integer teacherType;

    private String photo;

    private Integer company;

    private Integer sector;
    private Integer phase;

    private Integer postingNature;


    private String whatsapp_number;


    private String dob;


    private String c_address;


    private String salarycode;


    private Integer bg_id;

    public String getWhatsapp_number() {
        return whatsapp_number;
    }

    public void setWhatsapp_number(String whatsapp_number) {
        this.whatsapp_number = whatsapp_number;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getC_address() {
        return c_address;
    }

    public void setC_address(String c_address) {
        this.c_address = c_address;
    }

    public String getSalarycode() {
        return salarycode;
    }

    public void setSalarycode(String salarycode) {
        this.salarycode = salarycode;
    }

    public Integer getBg_id() {
        return bg_id;
    }

    public void setBg_id(Integer bg_id) {
        this.bg_id = bg_id;
    }

    public Integer getCompany() {
        return company;
    }

    public void setCompany(Integer company) {
        this.company = company;
    }

    public Integer getSector() {
        return sector;
    }

    public void setSector(Integer sector) {
        this.sector = sector;
    }

    public Integer getPhase() {
        return phase;
    }

    public void setPhase(Integer phase) {
        this.phase = phase;
    }

    public Integer getPostingNature() {
        return postingNature;
    }

    public void setPostingNature(Integer postingNature) {
        this.postingNature = postingNature;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Integer getTeacherType() {
        return teacherType;
    }

    public void setTeacherType(Integer teacherType) {
        this.teacherType = teacherType;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public BigInteger getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(BigInteger mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getDistrict() {
        return district;
    }

    public void setDistrict(Integer district) {
        this.district = district;
    }

    public Integer getBlock() {
        return block;
    }

    public void setBlock(Integer block) {
        this.block = block;
    }

    public Integer getEducationalBlock() {
        return educationalBlock;
    }

    public void setEducationalBlock(Integer educationalBlock) {
        this.educationalBlock = educationalBlock;
    }

    public Integer getConstituency() {
        return constituency;
    }

    public void setConstituency(Integer constituency) {
        this.constituency = constituency;
    }

    public Integer getSchool() {
        return school;
    }

    public void setSchool(Integer school) {
        this.school = school;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getDojFirst() {
        return dojFirst;
    }

    public void setDojFirst(String dojFirst) {
        this.dojFirst = dojFirst;
    }

    public String getDojLPresentSchool() {
        return dojLPresentSchool;
    }

    public void setDojLPresentSchool(String dojLPresentSchool) {
        this.dojLPresentSchool = dojLPresentSchool;
    }

    public Integer getCaste() {
        return caste;
    }

    public void setCaste(Integer caste) {
        this.caste = caste;
    }

    public Integer getSubcaste() {
        return subcaste;
    }

    public void setSubcaste(Integer subcaste) {
        this.subcaste = subcaste;
    }

    public Integer getQualification() {
        return qualification;
    }

    public void setQualification(Integer qualification) {
        this.qualification = qualification;
    }

    public Integer getPro_qualification() {
        return pro_qualification;
    }

    public void setPro_qualification(Integer pro_qualification) {
        this.pro_qualification = pro_qualification;
    }

    public String getAadhaar() {
        return aadhaar;
    }

    public void setAadhaar(String aadhaar) {
        this.aadhaar = aadhaar;
    }

    @Override
    public String toString() {
        return "UsersDetails{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", mobileNumber=" + mobileNumber +
                ", state=" + state +
                ", district=" + district +
                ", block=" + block +
                ", educationalBlock=" + educationalBlock +
                ", constituency=" + constituency +
                ", school=" + school +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", roleId=" + roleId +
                ", employeeCode='" + employeeCode + '\'' +
                ", dojFirst='" + dojFirst + '\'' +
                ", dojLPresentSchool='" + dojLPresentSchool + '\'' +
                ", caste=" + caste +
                ", subcaste=" + subcaste +
                ", qualification=" + qualification +
                ", pro_qualification=" + pro_qualification +
                ", aadhaar='" + aadhaar + '\'' +
                ", teacherType=" + teacherType +
                ", photo='" + photo + '\'' +
                ", company=" + company +
                ", sector=" + sector +
                ", phase=" + phase +
                ", postingNature=" + postingNature +
                ", whatsapp_number='" + whatsapp_number + '\'' +
                ", dob='" + dob + '\'' +
                ", c_address='" + c_address + '\'' +
                ", salarycode='" + salarycode + '\'' +
                ", bg_id=" + bg_id +
                '}';
    }
}
