package com.swanimobiliaria.controller;

import com.swanimobiliaria.model.dto.VisitDTO;
import com.swanimobiliaria.model.service.VisitService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
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
            value = "Get all visit history",
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

    @ApiOperation(
            value = "Include a new visit",
            response = VisitDTO.class
    )
    @ApiResponse(
            code = 201,
            message = "Created",
            response = VisitDTO.class
    )
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public VisitDTO createVisit(@Valid @RequestBody VisitDTO visitDTO) {
        return visitService.createVisit(visitDTO);
    }

    @ApiOperation(
            value = "Return upcoming visits",
            response = VisitDTO.class
    )
    @ApiResponse(
            code = 200,
            message = "Success",
            response = VisitDTO.class
    )
    @GetMapping(
            path = "/all"
    )
    public List<VisitDTO> getUpcomingVisits() {
        return visitService.getUpcomingVisits();
    }


}
