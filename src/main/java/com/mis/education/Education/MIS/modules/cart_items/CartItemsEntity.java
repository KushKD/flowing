package com.mis.education.Education.MIS.modules.cart_items;

import com.mis.education.Education.MIS.modules.cart.CartEntity;
import com.mis.education.Education.MIS.modules.products.entity.ProductsEntity;
import com.mis.education.Education.MIS.modules.user.entity.UserEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="mst_cartitem")
public class CartItemsEntity {

    @Id
    @GeneratedValue(generator = "mst_cartitem_cartitem_id_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "mst_cartitem_cartitem_id_seq", sequenceName = "public.mst_cartitem_cartitem_id_seq", initialValue = 1, allocationSize = 1)
    @Column(name="cartitem_id")
    private Integer cartItemId;

   // @OneToOne
    @Column(name="user_id")
    private Integer userId;


   // @OneToOne
    @Column(name="cart_id")
    private Integer cartId;

    @OneToOne
    @JoinColumn(name="product_id")
    private ProductsEntity productsEntity;

    @Column(name="product_quantity")
    private Integer productQuantity;

    @Column(name = "createddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name="active")
    private boolean active;

    public Integer getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(Integer cartItemId) {
        this.cartItemId = cartItemId;
    }



    public ProductsEntity getProductsEntity() {
        return productsEntity;
    }

    public void setProductsEntity(ProductsEntity productsEntity) {
        this.productsEntity = productsEntity;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    @Override
    public String toString() {
        return "CartItemsEntity{" +
                "cartItemId=" + cartItemId +
                ", userId=" + userId +
                ", cartId=" + cartId +
                ", productsEntity=" + productsEntity +
                ", productQuantity=" + productQuantity +
                ", createdDate=" + createdDate +
                ", active=" + active +
                '}';
    }
}
