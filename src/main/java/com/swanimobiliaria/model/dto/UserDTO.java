package com.swanimobiliaria.model.dto;

import com.swanimobiliaria.model.type.UserType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Builder
@Data
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

    @ApiModelProperty(
            value = "User's type",
            required = true,
            dataType = "com.swanimobiliaria.model.type.UserType",
            allowableValues = "VISITOR, ADMIN"
    )
    private UserType type;


}
