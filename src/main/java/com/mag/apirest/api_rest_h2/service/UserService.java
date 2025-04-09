package com.mag.apirest.api_rest_h2.service;

import com.mag.apirest.api_rest_h2.domain.UserRequestDTO;
import com.mag.apirest.api_rest_h2.model.User;
import java.util.List;
import java.util.UUID;

public interface UserService {

    User createUser(UserRequestDTO userRequestDTO);

    User getUserById(UUID id);

    List<User> getAllUsers();


}
