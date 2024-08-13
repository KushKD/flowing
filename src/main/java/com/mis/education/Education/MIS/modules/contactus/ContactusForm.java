package com.mis.education.Education.MIS.modules.contactus;

import java.io.Serializable;

public class ContactusForm implements Serializable {

    private String name;
    private String email;
    private String phone;
    private String support_for;
    private String message;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSupport_for() {
        return support_for;
    }

    public void setSupport_for(String support_for) {
        this.support_for = support_for;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ContactusForm{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", support_for='" + support_for + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
