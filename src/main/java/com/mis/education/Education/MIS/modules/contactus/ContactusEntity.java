package com.mis.education.Education.MIS.modules.contactus;

import javax.persistence.*;
import java.util.Date;




@Entity
@Table(name="mst_queries")
public class ContactusEntity {

    @Id
    @GeneratedValue(generator = "mst_queries_query_id_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "mst_queries_query_id_seq", sequenceName = "public.mst_queries_query_id_seq", initialValue = 1, allocationSize = 1)
    @Column(name = "query_id")
    private Integer queryId;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "support_for")
    private String supportFor;

    @Column(name = "message")
    private String message;

    @Column(name = "active")
    private boolean active;

    @Column(name = "createddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;


    public Integer getQueryId() {
        return queryId;
    }

    public void setQueryId(Integer queryId) {
        this.queryId = queryId;
    }

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

    public String getSupportFor() {
        return supportFor;
    }

    public void setSupportFor(String supportFor) {
        this.supportFor = supportFor;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    @Override
    public String toString() {
        return "ContactusEntity{" +
                "queryId=" + queryId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", supportFor='" + supportFor + '\'' +
                ", message='" + message + '\'' +
                ", active=" + active +
                ", createdDate=" + createdDate +
                '}';
    }
}