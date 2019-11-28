package com.swanimobiliaria.model.repository;

import com.swanimobiliaria.model.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserJpaRepository extends JpaRepository<User, UUID> {

    Optional<User> findByUsername(String username);
}
