package com.mis.education.Education.MIS.modules.products.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name="mst_products_thumbnails")
public class ProductsThumbnail implements Serializable {

    @Id
    @GeneratedValue(generator = "mst_products_thumbnails_thumbnail_id_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "mst_products_thumbnails_thumbnail_id_seq", sequenceName = "public.mst_products_thumbnails_thumbnail_id_seq", initialValue = 1, allocationSize = 1)
    @Column(name="thumbnail_id")
    private Integer thumbnailId;


    @Column(name="document_name")
    private String documentName;

    @Column(name = "product_id")
    private Integer productId;


    @Column (name="uploaded_by")
    private Integer enteredBy;

    @Column(name="active")
    private boolean active;

    @Column(name = "createddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "lastmodifieddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedOn;

    public Integer getThumbnailId() {
        return thumbnailId;
    }

    public void setThumbnailId(Integer thumbnailId) {
        this.thumbnailId = thumbnailId;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getEnteredBy() {
        return enteredBy;
    }

    public void setEnteredBy(Integer enteredBy) {
        this.enteredBy = enteredBy;
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
        return "ProductsThumbnail{" +
                "thumbnailId=" + thumbnailId +
                ", documentName='" + documentName + '\'' +
                ", productId=" + productId +
                ", enteredBy=" + enteredBy +
                ", active=" + active +
                ", createdDate=" + createdDate +
                ", updatedOn=" + updatedOn +
                '}';
    }
}
