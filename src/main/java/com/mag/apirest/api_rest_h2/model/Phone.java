package com.mag.apirest.api_rest_h2.model;

import jakarta.persistence.*;

@Entity
@Table (name = "phones")
public class Phone {

    @Id
    @Column (name = "id")
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @Column (name = "phonenumber", nullable = false)
    private String phoneNumber;

    @Column (name = "citycode")
    private String cityCode;

    @Column (name = "countrycode")
    private String countryCode;

//    @ManyToOne
//    @JoinColumn(name = "user_id", nullable = false, updatable = false)
//    private User user;

    public Phone() {
    }

    public Phone(Long id, String phoneNumber, String cityCode, String countryCode) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.cityCode = cityCode;
        this.countryCode = countryCode;
        //this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

}
