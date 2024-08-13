package com.mis.education.Education.MIS.modules.cart;

import java.io.Serializable;

public class ProductCart {
    private int quantity;
    private int product_variation_id;

    // Getters and setters
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getProduct_variation_id() {
        return product_variation_id;
    }

    public void setProduct_variation_id(int product_variation_id) {
        this.product_variation_id = product_variation_id;
    }
}
