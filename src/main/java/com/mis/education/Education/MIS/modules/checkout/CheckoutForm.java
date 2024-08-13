package com.mis.education.Education.MIS.modules.checkout;

import java.io.Serializable;

public class CheckoutForm implements Serializable {

    private String phone;
    private String alternatePhone;
    private String additionalInfo;
    private String paymentMethord;
    private Integer shippingAddressId;
    private Integer billingAddressId;
    private Double total;
    private Integer items;
    private Integer cartId;


    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getItems() {
        return items;
    }

    public void setItems(Integer items) {
        this.items = items;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAlternatePhone() {
        return alternatePhone;
    }

    public void setAlternatePhone(String alternatePhone) {
        this.alternatePhone = alternatePhone;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public String getPaymentMethord() {
        return paymentMethord;
    }

    public void setPaymentMethord(String paymentMethord) {
        this.paymentMethord = paymentMethord;
    }

    public Integer getShippingAddressId() {
        return shippingAddressId;
    }

    public void setShippingAddressId(Integer shippingAddressId) {
        this.shippingAddressId = shippingAddressId;
    }

    public Integer getBillingAddressId() {
        return billingAddressId;
    }

    public void setBillingAddressId(Integer billingAddressId) {
        this.billingAddressId = billingAddressId;
    }

    @Override
    public String toString() {
        return "CheckoutForm{" +
                "phone='" + phone + '\'' +
                ", alternatePhone='" + alternatePhone + '\'' +
                ", additionalInfo='" + additionalInfo + '\'' +
                ", paymentMethord='" + paymentMethord + '\'' +
                ", shippingAddressId=" + shippingAddressId +
                ", billingAddressId=" + billingAddressId +
                ", total=" + total +
                ", items=" + items +
                ", cartId=" + cartId +
                '}';
    }
}
