package com.swanimobiliaria.model.domain;

import com.swanimobiliaria.model.type.BusinessType;
import com.swanimobiliaria.model.type.PropertyType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
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
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "cod_ref")
    private Integer codRef;

}
