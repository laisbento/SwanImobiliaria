package com.swanimobiliaria.model.converter;

import com.swanimobiliaria.model.domain.Visit;
import com.swanimobiliaria.model.dto.VisitDTO;
import lombok.experimental.UtilityClass;

@UtilityClass
public class VisitConverter {

    public VisitDTO buildDTO(Visit visit) {
        return VisitDTO.builder()
                .id(visit.getId())
                .propertyId(visit.getImovel())
                .name(visit.getNome())
                .email(visit.getEmail())
                .phone(visit.getTelefone())
                .visitDate(visit.getData())
                .build();
    }

    public Visit buildDomain(VisitDTO visitDTO) {
        Visit visit = new Visit();
        visit.setImovel(visitDTO.getPropertyId());
        visit.setNome(visitDTO.getName());
        visit.setEmail(visitDTO.getEmail());
        visit.setData(visitDTO.getVisitDate());
        visit.setTelefone(visitDTO.getPhone());
        return visit;
    }
}
