package com.mag.apirest.api_rest_h2.controller;

import com.mag.apirest.api_rest_h2.domain.UserRequestDTO;
import com.mag.apirest.api_rest_h2.exceptions.ErrorMessage;
import com.mag.apirest.api_rest_h2.exceptions.UserException;
import com.mag.apirest.api_rest_h2.model.User;
import com.mag.apirest.api_rest_h2.service.UserService;
import com.mag.apirest.api_rest_h2.service.impl.UserServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
@Tag(name = "Controlador Usuarios")
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(summary = "Entrada para la creación de usuario")
    @PostMapping("/create")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserRequestDTO userRequestDTO){
        try {
            User createdUser = userService.createUser(userRequestDTO);
            return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
        } catch (UserException e) {
            ErrorMessage errorMessage = new ErrorMessage(e.getMessage());
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(summary = "Entrada para listar los usuarios en BD")
    @GetMapping
    public ResponseEntity<?> getAllUsers(){
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @Operation(summary = "Entrada para buscar un usuario por su ID" )
    @GetMapping("{id}")
    public ResponseEntity<?> searchUserById(@PathVariable("id") UUID id){
        User user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
