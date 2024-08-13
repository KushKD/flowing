package com.mis.education.Education.MIS.modules.role.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="roles")
public class RolesEntity   {

    @Id
    @GeneratedValue(generator = "roles_role_id_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "roles_role_id_seq", sequenceName = "public.roles_role_id_seq", initialValue = 1, allocationSize = 1)
    @Column(name="role_id")
    private Long roleId;

    @Column(name="role_name")
    private String roleName;

    @Column(name="role_description")
    private String roleDescription;

    @Column(name="active")
    private boolean active;


    @Column(name = "createddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "lastmodifieddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedOn;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    @Override
    public String toString() {
        return "RolesEntity{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", roleDescription='" + roleDescription + '\'' +
                ", active=" + active +
                ", createdDate=" + createdDate +
                ", updatedOn=" + updatedOn +
                '}';
    }
}