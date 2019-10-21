package com.swanimobiliaria.service;

import com.swanimobiliaria.converter.PropertyConverter;
import com.swanimobiliaria.converter.PropertyEditableConverter;
import com.swanimobiliaria.domain.Property;
import com.swanimobiliaria.dto.PropertyDTO;
import com.swanimobiliaria.exception.ResourceNotFoundException;
import com.swanimobiliaria.repository.PropertyJpaRepository;
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
        Property property = propertyJpaRepository.findById(propertyId).orElseThrow(() -> new ResourceNotFoundException("Property not found!"));
        propertyJpaRepository.delete(property);
    }

    public PropertyDTO updateProperty(UUID propertyId, PropertyDTO propertyDTO){
        Property property = propertyJpaRepository.findById(propertyId).orElseThrow(() -> new ResourceNotFoundException("Property not found!"));
        Property updatedProperty = propertyJpaRepository.save(PropertyEditableConverter.fromDTOtoDomain(property, propertyDTO));
        return PropertyConverter.fromDomainToDTO(updatedProperty);
    }
}
