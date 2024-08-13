package com.mis.education.Education.MIS.modules.products.form;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.Arrays;

public class ProductForm implements Serializable {

    private String productId;
    private String productName;
    private String shortDescription;
    private String longDescription;
    private String productTax;
    private String productPrice;

    private MultipartFile productImage = null;
    private MultipartFile[] productThumbnails = null;

    private String isActive;

    private String isDeleted;

    public MultipartFile getProductImage() {
        return productImage;
    }

    public void setProductImage(MultipartFile productImage) {
        this.productImage = productImage;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
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

    public MultipartFile[] getProductThumbnails() {
        return productThumbnails;
    }

    public void setProductThumbnails(MultipartFile[] productThumbnails) {
        this.productThumbnails = productThumbnails;
    }

    @Override
    public String toString() {
        return "ProductForm{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", longDescription='" + longDescription + '\'' +
                ", productTax='" + productTax + '\'' +
                ", productPrice='" + productPrice + '\'' +
                ", productImage=" + productImage +
                ", productThumbnails=" + Arrays.toString(productThumbnails) +
                ", isActive='" + isActive + '\'' +
                ", isDeleted='" + isDeleted + '\'' +
                '}';
    }
}
