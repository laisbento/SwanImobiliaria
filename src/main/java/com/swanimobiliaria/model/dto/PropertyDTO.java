package com.swanimobiliaria.model.dto;

import com.swanimobiliaria.model.type.BusinessType;
import com.swanimobiliaria.model.type.PropertyType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

@ApiModel(
        value = "Imovel",
        description = "Model of a Imovel"
)
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

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public Integer getCodRef() {
        return codRef;
    }

    public void setCodRef(Integer codRef) {
        this.codRef = codRef;
    }
}
