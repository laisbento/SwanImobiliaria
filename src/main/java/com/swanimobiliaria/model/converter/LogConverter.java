package com.swanimobiliaria.model.converter;

import com.swanimobiliaria.model.domain.Log;
import com.swanimobiliaria.model.dto.LogDTO;

public class LogConverter {

    private LogConverter() {
    }

    public static Log fromDTOtoDomain(LogDTO logDTO) {
        Log log = new Log();
        log.setLogId(logDTO.getLogId());
        log.setRegistro(logDTO.getRegistro());
        log.setTimestamp(logDTO.getTimestamp());
        log.setUser(logDTO.getUser());
        return log;
    }
}
