package com.mis.education.Education.MIS.modules.cart;

import com.mis.education.Education.MIS.modules.cart_items.CartItemsEntity;
import com.mis.education.Education.MIS.modules.products.entity.ProductsEntity;
import com.mis.education.Education.MIS.modules.user.entity.UserEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="mst_cart")
public class CartEntity {


    @Id
    @GeneratedValue(generator = "mst_cart_cart_id_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "mst_cart_cart_id_seq", sequenceName = "public.mst_cart_cart_id_seq", initialValue = 1, allocationSize = 1)
    @Column(name="cart_id")
    private Integer cartId;

    @OneToOne
    @JoinColumn(name="user_id")
    private UserEntity userId;

//    @OneToMany(fetch = FetchType.EAGER)
//    @JoinColumn(name="cartitem_id")
    @OneToMany(mappedBy = "cartId", fetch = FetchType.EAGER)
    private List<CartItemsEntity> cartItemId ;

    @Column(name="quantity_id")
    private Integer quantityId;


    @Column(name="active")
    private boolean active;

    @Column(name="status")
    private String status;

    @Column(name = "createddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;


    public List<CartItemsEntity> getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(List<CartItemsEntity> cartItemId) {
        this.cartItemId = cartItemId;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public UserEntity getUserId() {
        return userId;
    }

    public void setUserId(UserEntity userId) {
        this.userId = userId;
    }

    public Integer getQuantityId() {
        return quantityId;
    }

    public void setQuantityId(Integer quantityId) {
        this.quantityId = quantityId;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "CartEntity{" +
                "cartId=" + cartId +
                ", userId=" + userId +
                ", cartItemId=" + cartItemId +
                ", quantityId=" + quantityId +
                ", active=" + active +
                ", status='" + status + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }
}
