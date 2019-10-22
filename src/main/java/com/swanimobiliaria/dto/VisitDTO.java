package com.swanimobiliaria.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.UUID;

@ApiModel(
        value = "Visit",
        description = "Model of a Visit"
)
public class VisitDTO {

    @ApiModelProperty(
            value = "Visit identification UUID",
            dataType = "string",
            example = "46ad237d-8e3d-4aaf-887b-dbeb362775b8"
    )
    private UUID id;

    @ApiModelProperty(
            value = "Property identification UUID",
            dataType = "string",
            example = "1d96a44b-ed7c-466c-9365-75914353c7c3"
    )
    private UUID propertyId;

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
            example = "19-98845-7070",
            required = true
    )
    private Integer phone;

    @ApiModelProperty(
            value = "Visit date",
            dataType = "date",
            example = "19/10/2020",
            required = true
    )
    private Date visitDate;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getPropertyId() {
        return propertyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }
}
