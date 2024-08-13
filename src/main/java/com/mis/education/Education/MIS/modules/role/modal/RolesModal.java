package com.mis.education.Education.MIS.modules.role.modal;

import java.io.Serializable;
import java.math.BigInteger;

public class RolesModal implements Serializable {

    private Long role_id;
    private String role_name;

    public RolesModal(Long role_id, String role_name) {
        this.role_id = role_id;
        this.role_name = role_name;
    }

    public Long getRole_id() {
        return role_id;
    }

    public void setRole_id(Long role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }



    @Override
    public String toString() {
        return "RolesModal{" +
                "role_id=" + role_id +
                ", role_name='" + role_name + '\'' +
                '}';
    }
}
