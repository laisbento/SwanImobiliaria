package com.swanimobiliaria.model.service;

import com.swanimobiliaria.model.converter.PropertyConverter;
import com.swanimobiliaria.model.domain.Property;
import com.swanimobiliaria.model.dto.PropertyDTO;
import com.swanimobiliaria.model.exception.ResourceNotFoundException;
import com.swanimobiliaria.model.repository.PropertyJpaRepository;
import com.swanimobiliaria.model.strategy.SimplePropertyStrategy;
import com.swanimobiliaria.model.type.PropertyType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PropertyService {

    private PropertyJpaRepository propertyJpaRepository;
    private SimplePropertyStrategy simplePropertyStrategy;

    @Autowired
    public PropertyService(PropertyJpaRepository propertyJpaRepository, SimplePropertyStrategy simplePropertyStrategy) {
        this.propertyJpaRepository = propertyJpaRepository;
        this.simplePropertyStrategy = simplePropertyStrategy;
    }

    public List<PropertyDTO> getImoveis() {
        return propertyJpaRepository.findAll()
                .stream()
                .map(PropertyConverter::fromDomainToDTO)
                .collect(Collectors.toList());
    }

    public PropertyDTO createProperty(PropertyDTO propertyDTO) {
        Property savedProperty = propertyJpaRepository.save(PropertyConverter.fromDTOtoDomain(propertyDTO));
        return PropertyConverter.fromDomainToDTO(savedProperty);
    }

    public void deleteProperty(Integer propertyId) {
        Property property = getProperty(propertyId);
        propertyJpaRepository.delete(property);
    }

    public PropertyDTO updateProperty(Integer propertyId, PropertyDTO propertyDTO) {
        Property property = getProperty(propertyId);
        Property updatedProperty = propertyJpaRepository.save(PropertyConverter.fromDTOtoDomain(property, propertyDTO));
        return PropertyConverter.fromDomainToDTO(updatedProperty);
    }

    public PropertyDTO getPropertyById(Integer propertyId) {
        Property property = getProperty(propertyId);
        return PropertyConverter.fromDomainToDTO(property);
    }

    public List<PropertyDTO> getPropertyByOptions(PropertyType propertyType, String city, Integer rooms, Double priceFrom, Double priceTo) {
        PropertyDTO propertyDTO = new PropertyDTO();
        propertyDTO.setPropertyType(propertyType);
        propertyDTO.setCidade(city);
        propertyDTO.setQuartos(rooms);

        return simplePropertyStrategy.chooseStrategy(propertyDTO, priceFrom, priceTo);
    }

    private Property getProperty(Integer propertyId) {
        return propertyJpaRepository.findById(propertyId).orElseThrow(() -> new ResourceNotFoundException("Property not found!"));
    }
}
