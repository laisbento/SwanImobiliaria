package com.swanimobiliaria.controller;

import com.swanimobiliaria.model.dto.LogDTO;
import com.swanimobiliaria.model.service.LogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Log")
@RequestMapping("/log")
@RestController
public class LogController {

    private LogService logService;

    @Autowired
    public LogController(LogService logService) {
        this.logService = logService;
    }

    @ApiOperation(
            value = "Add a new log event",
            response = LogDTO.class
    )
    @ApiResponse(
            code = 200,
            message = "Success",
            response = LogDTO.class
    )
    @PostMapping
    public void addLog(@RequestBody LogDTO logDTO){
        logService.addLog(logDTO);
    }

}
