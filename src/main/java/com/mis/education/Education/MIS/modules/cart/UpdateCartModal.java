package com.mis.education.Education.MIS.modules.cart;

import java.io.Serializable;


public class UpdateCartModal implements Serializable {

    private String action;
    private Integer id;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UpdateCartModal{" +
                "action='" + action + '\'' +
                ", id=" + id +
                '}';
    }
}
