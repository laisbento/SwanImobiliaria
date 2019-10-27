package com.swanimobiliaria.model.service;

import com.swanimobiliaria.model.converter.PropertyConverter;
import com.swanimobiliaria.model.converter.PropertyEditableConverter;
import com.swanimobiliaria.model.domain.Property;
import com.swanimobiliaria.model.dto.PropertyDTO;
import com.swanimobiliaria.model.exception.ResourceNotFoundException;
import com.swanimobiliaria.model.repository.PropertyJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PropertyService {
    
    private PropertyJpaRepository propertyJpaRepository;

    @Autowired
    public PropertyService(PropertyJpaRepository propertyJpaRepository) {
        this.propertyJpaRepository = propertyJpaRepository;
    }

    public List<PropertyDTO> getImoveis(){
        return propertyJpaRepository.findAll()
                .stream()
                .map(PropertyConverter::fromDomainToDTO)
                .collect(Collectors.toList());
    }

    public PropertyDTO createProperty(PropertyDTO propertyDTO){
        Property savedProperty = propertyJpaRepository.save(PropertyConverter.fromDTOtoDomain(propertyDTO));
        return PropertyConverter.fromDomainToDTO(savedProperty);
    }

    public void deleteProperty(UUID propertyId){
        Property property = getProperty(propertyId);
        propertyJpaRepository.delete(property);
    }

    public PropertyDTO updateProperty(UUID propertyId, PropertyDTO propertyDTO){
        Property property = getProperty(propertyId);
        Property updatedProperty = propertyJpaRepository.save(PropertyEditableConverter.fromDTOtoDomain(property, propertyDTO));
        return PropertyConverter.fromDomainToDTO(updatedProperty);
    }

    public PropertyDTO getPropertyById(UUID propertyId){
        Property property = getProperty(propertyId);
        return PropertyConverter.fromDomainToDTO(property);
    }

    private Property getProperty(UUID propertyId) {
        return propertyJpaRepository.findById(propertyId).orElseThrow(() -> new ResourceNotFoundException("Property not found!"));
    }
}
