package com.swanimobiliaria.model.repository;

import com.swanimobiliaria.model.domain.Property;
import com.swanimobiliaria.model.type.PropertyType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PropertyJpaRepository extends JpaRepository<Property, Integer> {

    List<Property> findAll();

    List<Property> findAllByPropertyTypeAndQuartos(PropertyType propertyType, Integer quartos);

    List<Property> findAllByPropertyTypeAndQuartosAndCidadeLike(PropertyType propertyType, Integer quartos, String city);

    List<Property> findAllByPropertyTypeAndQuartosAndCidadeLikeAndValorGreaterThan(PropertyType propertyType, Integer quartos, String city, Double priceFrom);

    List<Property> findAllByPropertyTypeAndQuartosAndCidadeLikeAndValorBetween(PropertyType propertyType, Integer rooms, String city, Double priceFrom, Double priceTo);
}
