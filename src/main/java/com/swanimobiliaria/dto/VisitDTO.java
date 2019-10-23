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
            example = "46ad237d-8e3d-4aaf-887b-dbeb362775b8",
            required = false
    )
    private UUID id;

    @ApiModelProperty(
            value = "Property identification UUID",
            dataType = "string",
            example = "7643a688-5dcd-10d7-6eab-d7979a72cb7b",
            required = true
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

    public void setPropertyId(UUID propertyId) {
        this.propertyId = propertyId;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }
}
