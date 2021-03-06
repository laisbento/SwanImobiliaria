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
                .map(PropertyConverter::buildDTO)
                .collect(Collectors.toList());
    }

    public PropertyDTO createProperty(UUID userId, PropertyDTO propertyDTO) {
        userService.findByUserId(userId);
        Property savedProperty = propertyJpaRepository.save(PropertyConverter.buildDomain(propertyDTO));
        return PropertyConverter.buildDTO(savedProperty);
    }

    public void deleteProperty(UUID userId, Integer propertyId) {
        userService.findByUserId(userId);
        Property property = getProperty(propertyId);
        propertyJpaRepository.delete(property);
    }

    public PropertyDTO updateProperty(UUID userId, Integer propertyId, PropertyDTO propertyDTO) {
        userService.findByUserId(userId);
        Property property = getProperty(propertyId);
        Property updatedProperty = propertyJpaRepository.save(PropertyConverter.buildDomain(property, propertyDTO));
        return PropertyConverter.buildDTO(updatedProperty);
    }

    public PropertyDTO getPropertyById(Integer propertyId) {
        Property property = getProperty(propertyId);
        //adding for testing purposes only
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return PropertyConverter.buildDTO(property);
    }

    public List<PropertyDTO> getPropertyByOptions(String searchParam, PropertyType propertyType, String city, Integer rooms, Double priceFrom, Double priceTo) {
        if (Objects.nonNull(searchParam)) {
            return propertyJpaRepository
                    .findAllBySearchTerm(searchParam)
                    .stream()
                    .map(PropertyConverter::buildDTO)
                    .collect(Collectors.toList());
        }
        PropertyDTO propertyDTO = PropertyDTO.builder()
                .propertyType(propertyType)
                .cidade(city)
                .quartos(rooms)
                .build();

        return simplePropertyStrategy.chooseStrategy(propertyDTO, priceFrom, priceTo);
    }

    private Property getProperty(Integer propertyId) {
        return propertyJpaRepository.findById(propertyId).orElseThrow(() -> new ResourceNotFoundException("Property not found!"));
    }

    public List<PropertyDTO> getRandomProperty() {
        long total = propertyJpaRepository.count();
        int id = (int) ((random() / 3) * total);
        return getImoveis(id, 3);
    }
}
