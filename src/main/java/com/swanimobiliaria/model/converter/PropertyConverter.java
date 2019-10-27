package com.swanimobiliaria.model.converter;

import com.swanimobiliaria.model.domain.Property;
import com.swanimobiliaria.model.dto.PropertyDTO;

public class PropertyConverter {

    private PropertyConverter() {
    }

    public static PropertyDTO fromDomainToDTO(Property property){
        PropertyDTO propertyDTO = new PropertyDTO();
        propertyDTO.setId(property.getId());
        propertyDTO.setPropertyType(property.getImovelType());
        propertyDTO.setRua(property.getRua());
        propertyDTO.setNumero(property.getNumero());
        propertyDTO.setCidade(property.getCidade());
        propertyDTO.setEstado(property.getEstado());
        propertyDTO.setCep(property.getCep());
        propertyDTO.setQuartos(property.getQuartos());
        propertyDTO.setBanheiros(property.getBanheiros());
        propertyDTO.setVagas(property.getVagas());
        propertyDTO.setArea(property.getArea());
        propertyDTO.setBusinessType(property.getNegocioType());
        propertyDTO.setThumbnail(property.getThumbnail());
        propertyDTO.setValor(property.getValor());
        propertyDTO.setLat(property.getLat());
        propertyDTO.setLng(property.getLng());
        return propertyDTO;
    }

    public static Property fromDTOtoDomain(PropertyDTO propertyDTO){
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
        return property;
    }
}
