package com.swanimobiliaria.model.converter;

import com.swanimobiliaria.model.domain.Visit;
import com.swanimobiliaria.model.dto.VisitDTO;

public class VisitConverter {

    private VisitConverter() {
    }

    public static VisitDTO fromDomainToDTO(Visit visit) {
        VisitDTO visitDTO = new VisitDTO();
        visitDTO.setId(visit.getId());
        visitDTO.setPropertyId(visit.getImovel());
        visitDTO.setName(visit.getNome());
        visitDTO.setEmail(visit.getEmail());
        visitDTO.setPhone(visit.getTelefone());
        visitDTO.setVisitDate(visit.getData());

        return visitDTO;
    }

    public static Visit fromDTOtoDomain(VisitDTO visitDTO) {
        Visit visit = new Visit();
        visit.setImovel(visitDTO.getPropertyId());
        visit.setNome(visitDTO.getName());
        visit.setEmail(visitDTO.getEmail());
        visit.setData(visitDTO.getVisitDate());
        visit.setTelefone(visitDTO.getPhone());
        return visit;
    }
}
