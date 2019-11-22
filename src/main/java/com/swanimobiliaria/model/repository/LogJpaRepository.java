package com.swanimobiliaria.model.repository;

import com.swanimobiliaria.model.domain.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LogJpaRepository extends JpaRepository<Log, UUID> {

}
