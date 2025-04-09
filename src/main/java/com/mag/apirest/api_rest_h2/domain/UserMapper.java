package com.mag.apirest.api_rest_h2.domain;

import com.mag.apirest.api_rest_h2.model.Phone;
import com.mag.apirest.api_rest_h2.model.User;
import com.mag.apirest.api_rest_h2.service.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JWTService jwtService;

    public User mapUserFromRequest(UserRequestDTO userRequestDTO){
        User userTemp = new User();
        LocalDateTime currentDate = LocalDateTime.now();

        userTemp.setFullName(userRequestDTO.getName());
        userTemp.setEmail(userRequestDTO.getEmail());

        String encodedPassword = passwordEncoder.encode(userRequestDTO.getPassword());
        userTemp.setPassword(encodedPassword);

        userTemp.setPhoneList(userRequestDTO.getPhones().stream().map(this::mapPhoneFromRequest).collect(Collectors.toList()));;
        userTemp.setCreatedDate(currentDate);
        userTemp.setModifiedDate(currentDate);
        userTemp.setLastLoginDate(currentDate);
        userTemp.setToken(jwtService.generateToken(userRequestDTO.getEmail()));
        userTemp.setActive(true);

        return userTemp;
    }

    public Phone mapPhoneFromRequest(PhoneRequestDTO phoneRequestDTO){
        Phone phoneTemp = new Phone();

        phoneTemp.setPhoneNumber(phoneRequestDTO.getNumber());
        phoneTemp.setCityCode(phoneRequestDTO.getCity());
        phoneTemp.setCountryCode(phoneRequestDTO.getCountry());

        return phoneTemp;

    }
}
