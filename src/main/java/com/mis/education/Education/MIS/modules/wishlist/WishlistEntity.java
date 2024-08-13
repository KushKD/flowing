package com.mis.education.Education.MIS.modules.wishlist;

import com.mis.education.Education.MIS.modules.products.entity.ProductsEntity;
import com.mis.education.Education.MIS.modules.user.entity.UserEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="wishlist")
public class WishlistEntity {

    @Id
    @GeneratedValue(generator = "wishlist_wishlist_id_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "wishlist_wishlist_id_seq", sequenceName = "public.wishlist_wishlist_id_seq", initialValue = 1, allocationSize = 1)
    @Column(name="wishlist_id")
    private Integer wishListId;

    @OneToOne
    @JoinColumn (name="user_id")
    private UserEntity userId;

    @OneToOne
    @JoinColumn (name="product_id")
    private ProductsEntity productId;

    @Column(name="quantity")
    private Integer quantity;

    @Column(name="active")
    private boolean active;

    @Column(name = "createddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;


    public Integer getWishListId() {
        return wishListId;
    }

    public void setWishListId(Integer wishListId) {
        this.wishListId = wishListId;
    }

    public UserEntity getUserId() {
        return userId;
    }

    public void setUserId(UserEntity userId) {
        this.userId = userId;
    }

    public ProductsEntity getProductId() {
        return productId;
    }

    public void setProductId(ProductsEntity productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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
        return "WishlistEntity{" +
                "wishListId=" + wishListId +
                ", userId=" + userId +
                ", productId=" + productId +
                ", quantity=" + quantity +
                ", active=" + active +
                ", createdDate=" + createdDate +
                '}';
    }
}
