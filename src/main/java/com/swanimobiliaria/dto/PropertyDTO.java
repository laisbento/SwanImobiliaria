package com.swanimobiliaria.dto;

import com.swanimobiliaria.type.PropertyType;
import com.swanimobiliaria.type.BusinessType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.UUID;

@ApiModel(
        value = "Imovel",
        description = "Model of a Imovel"
)
public class PropertyDTO {

    @ApiModelProperty(
            value = "Property identification UUID",
            dataType = "string",
            example = "1d96a44b-ed7c-466c-9365-75914353c7c3"
    )
    private UUID id;

    @ApiModelProperty(
            value = "List of property types",
            dataType = "com.swanimobiliaria.type.PropertyType",
            allowableValues = "Chacára, Apartamento, Casa, Estúdio"
    )
    private PropertyType propertyType;

    @ApiModelProperty(
            value = "Property address",
            dataType = "string",
            example = "Rua Três Lagoas",
            required = true
    )
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
    private String cidade;

    @ApiModelProperty(
            value = "Property state",
            dataType = "string",
            example = "SP",
            required = true
    )
    private String estado;

    @ApiModelProperty(
            value = "Property zip code",
            dataType = "string",
            example = "13045850",
            required = true
    )
    private Integer cep;

    @ApiModelProperty(
            value = "Property geolocation",
            dataType = "string",
            example = "-37.72759, -73.78321"
    )
    private String geolocalizacao;

    @ApiModelProperty(
            value = "Number of rooms",
            dataType = "integer",
            example = "3"
    )
    private Integer quartos;

    @ApiModelProperty(
            value = "Number of bathrooms",
            dataType = "integer",
            example = "2"
    )
    private Integer banheiros;

    @ApiModelProperty(
            value = "Number of parking spots",
            dataType = "integer",
            example = "2"
    )
    private Integer vagas;

    @ApiModelProperty(
            value = "Property area",
            dataType = "integer",
            example = "389"
    )
    private Double area;

    @ApiModelProperty(
            value = "List of the business types available",
            dataType = "com.swanimobiliaria.type.BusinessType",
            allowableValues = "Aluguel, Venda"
    )
    private BusinessType businessType;

    @ApiModelProperty(
            value = "Link of the thumbnail (picture) of the property",
            dataType = "string",
            example = "www.endereco.com"
    )
    private String thumbnail;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public PropertyType getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(PropertyType propertyType) {
        this.propertyType = propertyType;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public String getGeolocalizacao() {
        return geolocalizacao;
    }

    public void setGeolocalizacao(String geolocalizacao) {
        this.geolocalizacao = geolocalizacao;
    }

    public Integer getQuartos() {
        return quartos;
    }

    public void setQuartos(Integer quartos) {
        this.quartos = quartos;
    }

    public Integer getBanheiros() {
        return banheiros;
    }

    public void setBanheiros(Integer banheiros) {
        this.banheiros = banheiros;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public BusinessType getBusinessType() {
        return businessType;
    }

    public void setBusinessType(BusinessType businessType) {
        this.businessType = businessType;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
