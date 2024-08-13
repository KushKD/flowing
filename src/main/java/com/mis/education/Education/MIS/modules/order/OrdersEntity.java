package com.mis.education.Education.MIS.modules.order;

import com.mis.education.Education.MIS.modules.cart.CartEntity;
import com.mis.education.Education.MIS.modules.user.entity.UserEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name="mst_orders")
public class OrdersEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "mst_orders_id_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "mst_orders_id_seq", sequenceName = "public.mst_orders_id_seq", initialValue = 1, allocationSize = 1)
    @Column(name="id")
    private Integer id;


    @Column(name="amount")
    private Double amount;

    @Column(name="currency")
    private String currency;

    @Column(name="receipt")
    private String receipt;

    @Column(name="order_id")
    private String orderId;

    @OneToOne
    @JoinColumn(name="user_id")
    private UserEntity userId;

    @OneToOne
    @JoinColumn(name="cart_id")
    private CartEntity cartId;

    @Column(name="gateway_entity")
    private String gatewayEntity;

    @Column(name="status")
    private String status;

    @Column(name="phone")
    private String phone;

    @Column(name="alternate_phone")
    private String alternatePhone;

    @Column(name="additional_info")
    private String additionalInfo;

    @Column(name="payment_methord")
    private String paymentMethord;

    @Column(name="attempts")
    private Integer attempts;

    @Column(name="shippingaddress_id")
    private Integer shippingaddressId;

    @Column(name="billingaddress_id")
    private Integer billingaddressId;

    @Column(name="active")
    private boolean active;

    @Column(name = "createddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public UserEntity getUserId() {
        return userId;
    }

    public void setUserId(UserEntity userId) {
        this.userId = userId;
    }

    public CartEntity getCartId() {
        return cartId;
    }

    public void setCartId(CartEntity cartId) {
        this.cartId = cartId;
    }

    public String getGatewayEntity() {
        return gatewayEntity;
    }

    public void setGatewayEntity(String gatewayEntity) {
        this.gatewayEntity = gatewayEntity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getAttempts() {
        return attempts;
    }

    public void setAttempts(Integer attempts) {
        this.attempts = attempts;
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

    public Integer getShippingaddressId() {
        return shippingaddressId;
    }

    public void setShippingaddressId(Integer shippingaddressId) {
        this.shippingaddressId = shippingaddressId;
    }

    public Integer getBillingaddressId() {
        return billingaddressId;
    }

    public void setBillingaddressId(Integer billingaddressId) {
        this.billingaddressId = billingaddressId;
    }

    @Override
    public String toString() {
        return "OrdersEntity{" +
                "id=" + id +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                ", receipt='" + receipt + '\'' +
                ", orderId='" + orderId + '\'' +
                ", userId=" + userId +
                ", cartId=" + cartId +
                ", gatewayEntity='" + gatewayEntity + '\'' +
                ", status='" + status + '\'' +
                ", phone='" + phone + '\'' +
                ", alternatePhone='" + alternatePhone + '\'' +
                ", additionalInfo='" + additionalInfo + '\'' +
                ", paymentMethord='" + paymentMethord + '\'' +
                ", attempts=" + attempts +
                ", shippingaddressId=" + shippingaddressId +
                ", billingaddressId=" + billingaddressId +
                ", active=" + active +
                ", createdDate=" + createdDate +
                '}';
    }
}
