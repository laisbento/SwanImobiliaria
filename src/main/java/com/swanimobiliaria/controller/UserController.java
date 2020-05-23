package com.swanimobiliaria.controller;

import com.swanimobiliaria.model.dto.UserDTO;
import com.swanimobiliaria.model.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
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

    @ApiOperation(
            value = "Returns all users",
            response = UserDTO.class
    )
    @ApiResponse(
            code = 200,
            message = "Success",
            response = UserDTO.class
    )
    @GetMapping(
            path = "/users"
    )
    public List<UserDTO> getUsers(@RequestHeader UUID authorization,
                                  @RequestParam(required = false) String username) {
        return userService.getUsers(authorization, username);
    }

    @ApiOperation(
            value = "Create an user",
            response = UserDTO.class
    )
    @ApiResponse(
            code = 201,
            message = "Success",
            response = UserDTO.class
    )
    @PostMapping(
            path = "/users"
    )
    public UserDTO createUser(@RequestHeader UUID authorization,
                              @RequestBody UserDTO userDTO) {
        return userService.createUser(authorization, userDTO);
    }

    @ApiOperation(
            value = "Delete an user"
    )
    @ApiResponse(
            code = 200,
            message = "Success"
    )
    @DeleteMapping(
            path = "/users/{userId}"
    )
    public void deleteAnUser(@RequestHeader UUID authorization,
                             @PathVariable UUID userId) {
        userService.deleteAnUser(authorization, userId);
    }
}
