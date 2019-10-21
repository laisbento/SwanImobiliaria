package com.swanimobiliaria.rest;

import com.swanimobiliaria.domain.Property;
import com.swanimobiliaria.dto.PropertyDTO;
import com.swanimobiliaria.service.PropertyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Api(value = "Imovel")
@RequestMapping("/imoveis")
@RestController
public class PropertyController {

    private PropertyService propertyService;

    @Autowired
    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @ApiOperation(
            value = "Get available properties",
            response = PropertyDTO.class
    )
    @ApiResponse(
            code = 200,
            message = "Success",
            response = PropertyDTO.class
    )
    @GetMapping
    public List<PropertyDTO> getProperties() {
        return propertyService.getImoveis();
    }

    @ApiOperation(
            value = "Create a new property",
            response = PropertyDTO.class
    )
    @ApiResponse(
            code = 201,
            message = "Created",
            response = PropertyDTO.class
    )
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PropertyDTO createProperty(@RequestBody PropertyDTO propertyDTO) {
        return propertyService.createProperty(propertyDTO);
    }

    @ApiOperation(
            value = "Delete a property"
    )
    @ApiResponse(
            code = 200,
            message = "Success"
    )
    @DeleteMapping(
            path = "{propertyId}"
    )
    public void deleteProperty(@PathVariable UUID propertyId) {
        propertyService.deleteProperty(propertyId);
    }

    @ApiOperation(
            value = "Edit a Property",
            response = PropertyDTO.class
    )
    @ApiResponse(
            code = 200,
            message = "Success",
            response = PropertyDTO.class
    )
    @PutMapping(
            "/{propertyId}"
    )
    public PropertyDTO updateProperty(@PathVariable UUID propertyId, @RequestBody PropertyDTO propertyDTO) {
        return propertyService.updateProperty(propertyId, propertyDTO);
    }


}
