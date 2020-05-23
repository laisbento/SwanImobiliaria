package com.swanimobiliaria.model.dto;

import com.swanimobiliaria.model.type.BusinessType;
import com.swanimobiliaria.model.type.PropertyType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@ApiModel(
        value = "Imovel",
        description = "Model of a Imovel"
)
@Data
@Builder
public class PropertyDTO {

    @ApiModelProperty(
            value = "List of property types",
            dataType = "com.swanimobiliaria.model.type.PropertyType",
            allowableValues = "Chacara, Apartamento, Casa, Estudio"
    )
    @NotNull(message = "Type must be provided")
    private PropertyType propertyType;

    @ApiModelProperty(
            value = "Property address",
            dataType = "string",
            example = "Rua Três Lagoas",
            required = true
    )
    @NotNull(message = "Address must be provided")
    private String rua;

    @ApiModelProperty(
            value = "Property number address",
            dataType = "string",
            example = "506",
            required = true
    )
    private String numero;

    @ApiModelProperty(
            value = "Property city",
            dataType = "string",
            example = "Campinas",
            required = true
    )
    @NotNull(message = "City must be provided")
    private String cidade;

    @ApiModelProperty(
            value = "Property state",
            dataType = "string",
            example = "SP",
            required = true
    )
    @NotNull(message = "State must be provided")
    private String estado;

    @ApiModelProperty(
            value = "Property zip code",
            dataType = "string",
            example = "13045850",
            required = true
    )
    private Integer cep;

    @ApiModelProperty(
            value = "Number of rooms",
            dataType = "integer",
            example = "3"
    )
    @NotNull(message = "Number of rooms must be provided")
    private Integer quartos;

    @ApiModelProperty(
            value = "Number of bathrooms",
            dataType = "integer",
            example = "2"
    )
    @NotNull(message = "Number of bathrooms must be provided")
    private Integer banheiros;

    @ApiModelProperty(
            value = "Number of parking spots",
            dataType = "integer",
            example = "2"
    )
    @NotNull(message = "Number of parking spots must be provided")
    private Integer vagas;

    @ApiModelProperty(
            value = "Property area",
            dataType = "integer",
            example = "389"
    )
    @NotNull(message = "Area must be provided")
    private Double area;

    @ApiModelProperty(
            value = "List of the business types available",
            dataType = "com.swanimobiliaria.model.type.BusinessType",
            allowableValues = "Aluguel, Venda"
    )
    @NotNull(message = "Business type must be provided")
    private BusinessType businessType;

    @ApiModelProperty(
            value = "Link of the thumbnail (picture) of the property",
            dataType = "string",
            example = "www.endereco.com"
    )
    private String thumbnail;

    @ApiModelProperty(
            value = "Property's price",
            dataType = "double",
            example = "100000.00"
    )
    @NotNull(message = "Price must be provided")
    private Double valor;

    @ApiModelProperty(
            value = "Property's latitude",
            dataType = "string",
            example = "-37.72759"
    )
    @NotNull(message = "Latitude must be provided")
    private String lat;

    @ApiModelProperty(
            value = "Property's longitude",
            dataType = "string",
            example = "-73.78321"
    )
    @NotNull(message = "Longitude must be provided")
    private String lng;

    @ApiModelProperty(
            value = "Property's reference code",
            dataType = "string",
            example = "123"
    )
    private Integer codRef;

}
