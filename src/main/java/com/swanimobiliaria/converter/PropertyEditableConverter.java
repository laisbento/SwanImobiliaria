package com.swanimobiliaria.converter;

import com.swanimobiliaria.domain.Property;
import com.swanimobiliaria.dto.PropertyDTO;

public class PropertyEditableConverter {

    private PropertyEditableConverter() {
    }

    public static Property fromDTOtoDomain(Property property, PropertyDTO propertyDTO) {
        property.setPropertyType(propertyDTO.getPropertyType());
        property.setRua(propertyDTO.getRua());
        property.setNumero(propertyDTO.getNumero());
        property.setCidade(propertyDTO.getCidade());
        property.setEstado(propertyDTO.getEstado());
        property.setCep(propertyDTO.getCep());
        property.setGeolocalizacao(propertyDTO.getGeolocalizacao());
        property.setQuartos(propertyDTO.getQuartos());
        property.setBanheiros(propertyDTO.getBanheiros());
        property.setVagas(propertyDTO.getVagas());
        property.setArea(propertyDTO.getArea());
        property.setBusinessType(propertyDTO.getBusinessType());
        property.setThumbnail(propertyDTO.getThumbnail());
        return property;
    }
}
