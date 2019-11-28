package com.swanimobiliaria.model.domain;

import com.swanimobiliaria.model.type.BusinessType;
import com.swanimobiliaria.model.type.PropertyType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "imoveis")
public class Property {

    @Column(name = "tipo_imovel")
    @Enumerated(EnumType.STRING)
    private PropertyType propertyType;

    @Column(name = "rua")
    private String rua;

    @Column(name = "numero")
    private String numero;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "estado")
    private String estado;

    @Column(name = "cep")
    private Integer cep;

    @Column(name = "quartos")
    private Integer quartos;

    @Column(name = "banheiros")
    private Integer banheiros;

    @Column(name = "vagas")
    private Integer vagas;

    @Column(name = "area")
    private Double area;

    @Column(name = "tipo_negocio")
    @Enumerated(EnumType.STRING)
    private BusinessType businessType;

    @Column(name = "thumbnail")
    private String thumbnail;

    @Column(name = "valor")
    private Double valor;

    @Column(name = "lat")
    private String lat;

    @Column(name = "lng")
    private String lng;

    @Id
    @Column(name = "cod_ref")
    private Integer codRef;

    public PropertyType getImovelType() {
        return propertyType;
    }

    public void setPropertyType(PropertyType imovelType) {
        this.propertyType = imovelType;
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

    public BusinessType getNegocioType() {
        return businessType;
    }

    public void setBusinessType(BusinessType negocioType) {
        this.businessType = negocioType;
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
