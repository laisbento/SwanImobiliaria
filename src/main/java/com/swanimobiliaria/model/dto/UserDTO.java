package com.swanimobiliaria.model.dto;

import io.swagger.annotations.ApiModelProperty;

import java.util.UUID;

public class UserDTO {

    @ApiModelProperty(
            value = "User identification UUID",
            dataType = "string",
            example = "46ad237d-8e3d-4aaf-887b-dbeb362775b8",
            required = false
    )
    private UUID id;

    @ApiModelProperty(
            value = "User's username",
            dataType = "string",
            example = "laisbento",
            required = true
    )
    private String username;

    @ApiModelProperty(
            value = "User's password",
            dataType = "password",
            required = true
    )
    private String password;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
