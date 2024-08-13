package com.mis.education.Education.MIS.modules.checkout;

import java.io.Serializable;

public class CheckoutcompleteForm implements Serializable {

    private String razorpay_payment_id;
    private String amount;
    private String key;
    private String total;
    private String order_id;
    private String name;
    private String email;
    private String phone;
    private String notes;

    public String getRazorpay_payment_id() {
        return razorpay_payment_id;
    }

    public void setRazorpay_payment_id(String razorpay_payment_id) {
        this.razorpay_payment_id = razorpay_payment_id;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
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

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "CheckoutcompleteForm{" +
                "razorpay_payment_id='" + razorpay_payment_id + '\'' +
                ", amount='" + amount + '\'' +
                ", key='" + key + '\'' +
                ", total='" + total + '\'' +
                ", order_id='" + order_id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}

