package com.mag.apirest.api_rest_h2.domain;

public class PhoneRequestDTO {
    private String number;
    private String city;
    private String country;

    public PhoneRequestDTO() {
    }

    public PhoneRequestDTO(String number, String city, String country) {
        this.number = number;
        this.city = city;
        this.country = country;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
