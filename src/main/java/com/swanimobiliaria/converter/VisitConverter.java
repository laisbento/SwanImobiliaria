package com.swanimobiliaria.converter;

import com.swanimobiliaria.domain.Visit;
import com.swanimobiliaria.dto.VisitDTO;

public class VisitConverter {

    public static VisitDTO fromDomainToDTO(Visit visit){
        VisitDTO visitDTO = new VisitDTO();
        visitDTO.setId(visit.getId());
        visitDTO.setName(visit.getNome());
        visitDTO.setEmail(visit.getEmail());
        visitDTO.setPhone(visit.getTelefone());
        visitDTO.setVisitDate(visit.getData());
        return visitDTO;
    }
}
