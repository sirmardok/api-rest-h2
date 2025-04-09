package com.mag.apirest.api_rest_h2.service.impl;

import com.mag.apirest.api_rest_h2.domain.UserMapper;
import com.mag.apirest.api_rest_h2.domain.UserRequestDTO;
import com.mag.apirest.api_rest_h2.exceptions.UserException;
import com.mag.apirest.api_rest_h2.model.User;
import com.mag.apirest.api_rest_h2.repository.UserRepository;
import com.mag.apirest.api_rest_h2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public User createUser(UserRequestDTO userRequestDTO){

        User tempUser = userRepository.findByEmail(userRequestDTO.getEmail());
        if(tempUser != null){
            throw new UserException("El usuario ya existe");
        }
        User userNew = userMapper.mapUserFromRequest(userRequestDTO);
        return userRepository.save(userNew);
    }

    public User getUserById(UUID id){

        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.get();
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }


}
