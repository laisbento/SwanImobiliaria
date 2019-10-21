package com.swanimobiliaria.repository;

import com.swanimobiliaria.domain.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PropertyJpaRepository extends JpaRepository<Property, UUID> {
    List<Property> findAll();
}
