package com.mis.education.Education.MIS.modules.products.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="mst_products")
public class ProductsEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "mst_products_product_id_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "mst_products_product_id_seq", sequenceName = "public.mst_products_product_id_seq", initialValue = 1, allocationSize = 1)
    @Column(name="product_id")
    private Long productId;

    @Column(name="product_name")
    private String productName;


    @Column(name="product_image")
    private String productImage;

    @Column(name="short_description")
    private String shortDescription;

    @Column(name="long_description")
    private String longDescription;

    @Column(name="product_tax")
    private String productTax;

    @Column(name="product_price")
    private String productPrice;

    @Column(name="active")
    private boolean active;


    @Column(name = "createddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "updated_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedOn;

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getProductTax() {
        return productTax;
    }

    public void setProductTax(String productTax) {
        this.productTax = productTax;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
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
        return "ProductsEntity{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productImage='" + productImage + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", longDescription='" + longDescription + '\'' +
                ", productTax='" + productTax + '\'' +
                ", productPrice='" + productPrice + '\'' +
                ", active=" + active +
                ", createdDate=" + createdDate +
                ", updatedOn=" + updatedOn +
                '}';
    }
}
