package com.swanimobiliaria.repository;

import com.swanimobiliaria.domain.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface VisitJpaRepository extends JpaRepository<Visit, UUID> {
    List<Visit> findAll();
}
