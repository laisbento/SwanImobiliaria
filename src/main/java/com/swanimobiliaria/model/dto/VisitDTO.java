package com.swanimobiliaria.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@ApiModel(
        value = "Visit",
        description = "Model of a Visit"
)
@Builder
@Data
public class VisitDTO {

    @ApiModelProperty(
            value = "Visit identification UUID",
            dataType = "string",
            example = "46ad237d-8e3d-4aaf-887b-dbeb362775b8",
            required = false
    )
    private UUID id;

    @ApiModelProperty(
            value = "Property identification",
            dataType = "string",
            example = "123",
            required = true
    )
    private Integer propertyId;

    @ApiModelProperty(
            value = "Name of the property visitor",
            dataType = "string",
            example = "João da Silva",
            required = true
    )
    private String name;

    @ApiModelProperty(
            value = "Email of the property visitor",
            dataType = "string",
            example = "joao.da.silva@gmail.com",
            required = true
    )
    private String email;

    @ApiModelProperty(
            value = "Phone number of the property visitor",
            dataType = "string",
            example = "19988457070",
            required = true
    )
    private String phone;

    @ApiModelProperty(
            value = "Visit date",
            dataType = "date",
            example = "2019-10-24",
            required = true
    )
    private LocalDateTime visitDate;

}
