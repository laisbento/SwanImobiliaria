package com.swanimobiliaria.model.converter;

import com.swanimobiliaria.model.domain.Property;
import com.swanimobiliaria.model.dto.PropertyDTO;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PropertyConverter {

    public PropertyDTO buildDTO(Property property){
        return PropertyDTO.builder()
                .propertyType(property.getPropertyType())
                .rua(property.getRua())
                .numero(property.getNumero())
                .cidade(property.getCidade())
                .estado(property.getEstado())
                .cep(property.getCep())
                .quartos(property.getQuartos())
                .banheiros(property.getBanheiros())
                .vagas(property.getVagas())
                .area(property.getArea())
                .businessType(property.getBusinessType())
                .thumbnail(property.getThumbnail())
                .valor(property.getValor())
                .lat(property.getLat())
                .lng(property.getLng())
                .codRef(property.getCodRef())
                .build();
    }

    public Property buildDomain(PropertyDTO propertyDTO){
        Property property = new Property();
        property.setPropertyType(propertyDTO.getPropertyType());
        property.setRua(propertyDTO.getRua());
        property.setNumero(propertyDTO.getNumero());
        property.setCidade(propertyDTO.getCidade());
        property.setEstado(propertyDTO.getEstado());
        property.setCep(propertyDTO.getCep());
        property.setQuartos(propertyDTO.getQuartos());
        property.setBanheiros(propertyDTO.getBanheiros());
        property.setVagas(propertyDTO.getVagas());
        property.setArea(propertyDTO.getArea());
        property.setBusinessType(propertyDTO.getBusinessType());
        property.setThumbnail(propertyDTO.getThumbnail());
        property.setValor(propertyDTO.getValor());
        property.setLat(propertyDTO.getLat());
        property.setLng(propertyDTO.getLng());
        property.setCodRef(propertyDTO.getCodRef());
        return property;
    }

    public Property buildDomain(Property property, PropertyDTO propertyDTO) {
        property.setPropertyType(propertyDTO.getPropertyType());
        property.setRua(propertyDTO.getRua());
        property.setNumero(propertyDTO.getNumero());
        property.setCidade(propertyDTO.getCidade());
        property.setEstado(propertyDTO.getEstado());
        property.setCep(propertyDTO.getCep());
        property.setQuartos(propertyDTO.getQuartos());
        property.setBanheiros(propertyDTO.getBanheiros());
        property.setVagas(propertyDTO.getVagas());
        property.setArea(propertyDTO.getArea());
        property.setBusinessType(propertyDTO.getBusinessType());
        property.setValor(propertyDTO.getValor());
        property.setThumbnail(propertyDTO.getThumbnail());
        property.setLng(propertyDTO.getLng());
        property.setLat(propertyDTO.getLat());
        return property;
    }
}
