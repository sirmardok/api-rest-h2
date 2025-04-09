package com.mag.apirest.api_rest_h2.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mag.apirest.api_rest_h2.domain.PhoneRequestDTO;
import com.mag.apirest.api_rest_h2.domain.UserMapper;
import com.mag.apirest.api_rest_h2.domain.UserRequestDTO;
import com.mag.apirest.api_rest_h2.model.Phone;
import com.mag.apirest.api_rest_h2.model.User;
import com.mag.apirest.api_rest_h2.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(controllers = UserController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
@Disabled("feature disabled because is WIP")
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private UserService userService;

    //@Autowired
    //private UserMapper userMapper;

    @Autowired
    private ObjectMapper objectMapper;

    private UserRequestDTO userRequestDTO;

    @BeforeEach
    public void init() {
        userRequestDTO = new UserRequestDTO();
        userRequestDTO.setName("Miguel Garces");
        userRequestDTO.setEmail("sirmardok@gmail.com");
        userRequestDTO.setPassword("mardok2025");
        List<PhoneRequestDTO> phoneList = List.of(
                new PhoneRequestDTO("3136424266","1","57"));
        userRequestDTO.setPhones(phoneList);    }

    @Test
    public void userController_createUser_returnCreated() throws Exception {

        given(userService.createUser(ArgumentMatchers.any()))
                .willAnswer(invocation -> invocation.getArgument(0));

        ResultActions response = mockMvc.perform(post("/api/users/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(String.valueOf(userRequestDTO)));

        response.andExpect(MockMvcResultMatchers.status().isCreated());
    }

}
