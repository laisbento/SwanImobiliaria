package com.swanimobiliaria.model.repository;

import com.swanimobiliaria.model.domain.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface VisitJpaRepository extends JpaRepository<Visit, UUID> {

    List<Visit> findAll();

    @Query(value = "SELECT visit FROM Visit visit " +
            "WHERE visit.data > current_date")
    List<Visit> getUpcomingVisits();

    @Query(value = "SELECT visit FROM Visit visit WHERE visit.data = :tomorrow ")
    List<Visit> getNextDayVisits(@Param("tomorrow") Date tomorrow);
}
