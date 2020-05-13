package com.swanimobiliaria.controller;

import com.swanimobiliaria.model.dto.UserDTO;
import com.swanimobiliaria.model.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Api(value = "Login")
@RequestMapping("/public/admin")
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(
            value = "Login a user",
            response = UUID.class
    )
    @ApiResponse(
            code = 200,
            message = "Success",
            response = UUID.class
    )
    @PostMapping
    public UUID login(@RequestBody UserDTO userDTO) {
        return userService.findByUsernameAndPassword(userDTO.getUsername(), userDTO.getPassword());
    }
}
