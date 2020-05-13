package com.swanimobiliaria.model.service;

import com.swanimobiliaria.model.converter.PropertyConverter;
import com.swanimobiliaria.model.domain.Property;
import com.swanimobiliaria.model.dto.PropertyDTO;
import com.swanimobiliaria.model.exception.ResourceNotFoundException;
import com.swanimobiliaria.model.repository.PropertyJpaRepository;
import com.swanimobiliaria.model.strategy.SimplePropertyStrategy;
import com.swanimobiliaria.model.type.PropertyType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.lang.Math.random;

@Service
public class PropertyService {

    private final PropertyJpaRepository propertyJpaRepository;
    private final UserService userService;
    private final SimplePropertyStrategy simplePropertyStrategy;

    @Autowired
    public PropertyService(PropertyJpaRepository propertyJpaRepository, UserService userService, SimplePropertyStrategy simplePropertyStrategy) {
        this.propertyJpaRepository = propertyJpaRepository;
        this.userService = userService;
        this.simplePropertyStrategy = simplePropertyStrategy;
    }

    public List<PropertyDTO> getImoveis(int page, int size) {
        return propertyJpaRepository.findAll(PageRequest.of(page, size))
                .stream()
                .map(PropertyConverter::fromDomainToDTO)
                .collect(Collectors.toList());
    }

    public PropertyDTO createProperty(PropertyDTO propertyDTO) {
        Property savedProperty = propertyJpaRepository.save(PropertyConverter.fromDTOtoDomain(propertyDTO));
        return PropertyConverter.fromDomainToDTO(savedProperty);
    }

    public void deleteProperty(UUID userId, Integer propertyId) {
        UUID userById = userService.findByUserId(userId);
        if(Objects.nonNull(userById)) {
            Property property = getProperty(propertyId);
            propertyJpaRepository.delete(property);
        }
    }

    public PropertyDTO updateProperty(UUID userId, Integer propertyId, PropertyDTO propertyDTO) {
        userService.findByUserId(userId);
        Property property = getProperty(propertyId);
        Property updatedProperty = propertyJpaRepository.save(PropertyConverter.fromDTOtoDomain(property, propertyDTO));
        return PropertyConverter.fromDomainToDTO(updatedProperty);
    }

    public PropertyDTO getPropertyById(Integer propertyId) {
        Property property = getProperty(propertyId);
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return PropertyConverter.fromDomainToDTO(property);
    }

    public List<PropertyDTO> getPropertyByOptions(String searchParam, PropertyType propertyType, String city, Integer rooms, Double priceFrom, Double priceTo) {
        if(Objects.nonNull(searchParam)){
            return propertyJpaRepository
                    .findAllBySearchTerm(searchParam)
                    .stream()
                    .map(PropertyConverter::fromDomainToDTO)
                    .collect(Collectors.toList());
        }
        PropertyDTO propertyDTO = new PropertyDTO();
        propertyDTO.setPropertyType(propertyType);
        propertyDTO.setCidade(city);
        propertyDTO.setQuartos(rooms);

        return simplePropertyStrategy.chooseStrategy(propertyDTO, priceFrom, priceTo);
    }

    private Property getProperty(Integer propertyId) {
        return propertyJpaRepository.findById(propertyId).orElseThrow(() -> new ResourceNotFoundException("Property not found!"));
    }

    public List<PropertyDTO> getRandomProperty(){
        long total = propertyJpaRepository.count();
        int id = (int) ((random()/3) * total);
        return getImoveis(id, 3);
    }
}
