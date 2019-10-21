package com.swanimobiliaria.converter;

import com.swanimobiliaria.domain.Property;
import com.swanimobiliaria.dto.PropertyDTO;

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
        propertyDTO.setGeolocalizacao(property.getGeolocalizacao());
        propertyDTO.setQuartos(property.getQuartos());
        propertyDTO.setBanheiros(property.getBanheiros());
        propertyDTO.setVagas(property.getVagas());
        propertyDTO.setArea(property.getArea());
        propertyDTO.setBusinessType(property.getNegocioType());
        propertyDTO.setThumbnail(property.getThumbnail());
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
