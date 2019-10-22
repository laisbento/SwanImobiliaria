package com.swanimobiliaria.service;

import com.swanimobiliaria.converter.VisitConverter;
import com.swanimobiliaria.dto.VisitDTO;
import com.swanimobiliaria.repository.VisitJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VisitService {

    private VisitJpaRepository visitJpaRepository;

    @Autowired
    public VisitService(VisitJpaRepository visitJpaRepository) {
        this.visitJpaRepository = visitJpaRepository;
    }

    /**
     * This method return all the visit history - this includes the past ones
     **/
    public List<VisitDTO> getAllVisits(){
        return visitJpaRepository.findAll()
                .stream()
                .map(VisitConverter::fromDomainToDTO)
                .collect(Collectors.toList());
    }


}
