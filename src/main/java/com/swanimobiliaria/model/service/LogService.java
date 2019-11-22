package com.swanimobiliaria.model.service;

import com.swanimobiliaria.model.converter.LogConverter;
import com.swanimobiliaria.model.dto.LogDTO;
import com.swanimobiliaria.model.repository.LogJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogService {

    private LogJpaRepository logJpaRepository;

    @Autowired
    public LogService(LogJpaRepository logJpaRepository) {
        this.logJpaRepository = logJpaRepository;
    }

    public void addLog(LogDTO logDTO) {
        logJpaRepository.save(LogConverter.fromDTOtoDomain(logDTO));
    }
}
