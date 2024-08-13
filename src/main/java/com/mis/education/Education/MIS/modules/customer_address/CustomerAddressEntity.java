package com.mis.education.Education.MIS.modules.customer_address;

import com.mis.education.Education.MIS.modules.states.StatesMaster;
import com.mis.education.Education.MIS.modules.user.entity.UserEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="mst_address")
public class CustomerAddressEntity {

    @Id
    @GeneratedValue(generator = "mst_address_address_id_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "mst_address_address_id_seq", sequenceName = "public.mst_address_address_id_seq", initialValue = 1, allocationSize = 1)
    @Column(name="address_id")
    private Integer addressId;

    //userId
    @OneToOne
    @JoinColumn(name="userId")
    private UserEntity userId;


    @Column(name="country_id")
    private Integer countryId;

    @OneToOne
    @JoinColumn(name="state_id")
    private StatesMaster stateId;

    @Column(name="city")
    private String city;

    @Column(name="pincode")
    private Integer pincode;

    @Column(name="address")
    private String address;

    @Column(name="default_address")
    private boolean defaultAddress;

    @Column(name="active")
    private boolean active;

    @Column(name = "createddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;


    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public UserEntity getUserId() {
        return userId;
    }

    public void setUserId(UserEntity userId) {
        this.userId = userId;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public StatesMaster getStateId() {
        return stateId;
    }

    public void setStateId(StatesMaster stateId) {
        this.stateId = stateId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getPincode() {
        return pincode;
    }

    public void setPincode(Integer pincode) {
        this.pincode = pincode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isDefaultAddress() {
        return defaultAddress;
    }

    public void setDefaultAddress(boolean defaultAddress) {
        this.defaultAddress = defaultAddress;
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
        return "CustomerAddressEntity{" +
                "addressId=" + addressId +
                ", userId=" + userId +
                ", countryId=" + countryId +
                ", stateId=" + stateId +
                ", city='" + city + '\'' +
                ", pincode=" + pincode +
                ", address=" + address +
                ", defaultAddress=" + defaultAddress +
                ", active=" + active +
                ", createdDate=" + createdDate +
                '}';
    }
}
