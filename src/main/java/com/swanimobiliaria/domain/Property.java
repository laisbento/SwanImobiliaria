package com.swanimobiliaria.domain;

import com.swanimobiliaria.type.BusinessType;
import com.swanimobiliaria.type.PropertyType;
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

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id")
    private UUID id;

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

    @Column(name = "geolocalizacao")
    private String geolocalizacao;

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

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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
}
