package com.swanimobiliaria.model.repository;

import com.swanimobiliaria.model.domain.Property;
import com.swanimobiliaria.model.type.PropertyType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyJpaRepository extends JpaRepository<Property, Integer> {

    @Query("SELECT p FROM Property p WHERE lower(p.rua) like concat('%', lower(:searchTerm), '%') OR lower(p.cidade) like concat('%', lower(:searchTerm), '%')")
    List<Property> findAllBySearchTerm(String searchTerm);

    List<Property> findAllByPropertyTypeAndQuartos(PropertyType propertyType, Integer quartos);

    List<Property> findAllByPropertyTypeAndQuartosAndCidadeLike(PropertyType propertyType, Integer quartos, String city);

    List<Property> findAllByPropertyTypeAndQuartosAndCidadeLikeAndValorGreaterThan(PropertyType propertyType, Integer quartos, String city, Double priceFrom);

    List<Property> findAllByPropertyTypeAndQuartosAndCidadeLikeAndValorBetween(PropertyType propertyType, Integer rooms, String city, Double priceFrom, Double priceTo);
}
