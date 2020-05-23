package com.swanimobiliaria.model.strategy;

import com.swanimobiliaria.model.converter.PropertyConverter;
import com.swanimobiliaria.model.dto.PropertyDTO;
import com.swanimobiliaria.model.repository.PropertyJpaRepository;
import com.swanimobiliaria.model.type.PropertyType;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public abstract class PropertyStrategy {

    @Autowired
    private PropertyJpaRepository propertyJpaRepository;

    private List<PropertyDTO> findByTypeAndRooms(PropertyType propertyType, Integer rooms) {
        return propertyJpaRepository.findAllByPropertyTypeAndQuartos(propertyType, rooms)
                .stream()
                .map(PropertyConverter::buildDTO)
                .collect(Collectors.toList());
    }

    private List<PropertyDTO> findByTypeRoomsAndCity(PropertyType propertyType, Integer rooms, String city) {
        return propertyJpaRepository.findAllByPropertyTypeAndQuartosAndCidadeLike(propertyType, rooms, city)
                .stream()
                .map(PropertyConverter::buildDTO)
                .collect(Collectors.toList());
    }

    private List<PropertyDTO> findByTypeRoomsCityAndPriceFrom(PropertyType propertyType, Integer rooms, String city, Double priceFrom) {
        return propertyJpaRepository.findAllByPropertyTypeAndQuartosAndCidadeLikeAndValorGreaterThan(propertyType, rooms, city, priceFrom)
                .stream()
                .map(PropertyConverter::buildDTO)
                .collect(Collectors.toList());
    }

    private List<PropertyDTO> findByAllParameter(PropertyType propertyType, Integer rooms, String city, Double priceFrom, Double priceTo) {
        return propertyJpaRepository.findAllByPropertyTypeAndQuartosAndCidadeLikeAndValorBetween(propertyType, rooms, city, priceFrom, priceTo)
                .stream()
                .map(PropertyConverter::buildDTO)
                .collect(Collectors.toList());
    }

    public List<PropertyDTO> chooseStrategy(PropertyDTO propertyDTO, Double priceFrom, Double priceTo){
        if (propertyDTO.getCidade().isEmpty() && priceFrom == null && priceTo == null) {
            return findByTypeAndRooms(propertyDTO.getPropertyType(), propertyDTO.getQuartos());
        } else if (priceFrom == null && priceTo == null) {
            return findByTypeRoomsAndCity(propertyDTO.getPropertyType(), propertyDTO.getQuartos(), propertyDTO.getCidade());
        } else if (priceTo == null) {
            return findByTypeRoomsCityAndPriceFrom(propertyDTO.getPropertyType(), propertyDTO.getQuartos(), propertyDTO.getCidade(), priceFrom);
        } else {
            return findByAllParameter(propertyDTO.getPropertyType(), propertyDTO.getQuartos(), propertyDTO.getCidade(), priceFrom, priceTo);
        }
    }
}
