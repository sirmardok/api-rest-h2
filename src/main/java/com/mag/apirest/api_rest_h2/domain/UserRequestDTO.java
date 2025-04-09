package com.mag.apirest.api_rest_h2.domain;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

import java.util.List;

public class UserRequestDTO {

    @NotEmpty(message = "Nombre de usuario es requerido")
    private String name;

    @NotEmpty(message = "Correo electronico es requerido")
    @Email(message = "Correo electronico es invalido")
    private String email;

    @NotEmpty(message = "Password es requerido")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", message = "Password es incorrecto")
    private String password;

    @NotEmpty(message = "Se requiere al menos un telefono")
    private List<PhoneRequestDTO> phones;

    public UserRequestDTO() {
    }

    public UserRequestDTO(String name, String email, String password, List<PhoneRequestDTO> phones) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phones = phones;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<PhoneRequestDTO> getPhones() {
        return phones;
    }

    public void setPhones(List<PhoneRequestDTO> phones) {
        this.phones = phones;
    }
}
