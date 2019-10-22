package com.swanimobiliaria.rest;

import com.swanimobiliaria.dto.VisitDTO;
import com.swanimobiliaria.service.VisitService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "Visitas")
@RequestMapping("/visitas")
@RestController
public class VisitController {

    private VisitService visitService;

    @Autowired
    public VisitController(VisitService visitService) {
        this.visitService = visitService;
    }

    @ApiOperation(
            value = "Get all visits appointments",
            response = VisitDTO.class
    )
    @ApiResponse(
            code = 200,
            message = "Success",
            response = VisitDTO.class
    )
    @GetMapping
    public List<VisitDTO> getProperties() {
        return visitService.getAllVisits();
    }

}
