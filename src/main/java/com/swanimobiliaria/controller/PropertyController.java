package com.swanimobiliaria.controller;

import com.swanimobiliaria.model.dto.PropertyDTO;
import com.swanimobiliaria.model.service.PropertyService;
import com.swanimobiliaria.model.type.PropertyType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Api(value = "Imovel")
@RequestMapping("/public/imoveis")
@RestController
public class PropertyController {

    private final PropertyService propertyService;

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
    public List<PropertyDTO> getProperties(@RequestParam(required = false, defaultValue = "0") int page,
                                           @RequestParam(required = false, defaultValue = "50") int size) {
        return propertyService.getImoveis(page, size);
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
    public PropertyDTO createProperty(@RequestHeader UUID authorization,
                                      @Valid @RequestBody PropertyDTO propertyDTO) {
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
            path = "/{propertyId}"
    )
    public void deleteProperty(@RequestHeader UUID authorization,
                               @PathVariable Integer propertyId) {
        propertyService.deleteProperty(authorization, propertyId);
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
    @PatchMapping(
            path = "/{propertyId}"
    )
    public PropertyDTO updateProperty(@RequestHeader UUID authorization,
                                      @PathVariable Integer propertyId,
                                      @RequestBody PropertyDTO propertyDTO) {
        return propertyService.updateProperty(authorization, propertyId, propertyDTO);
    }

    @ApiOperation(
            value = "Get a property by its id",
            response = PropertyDTO.class
    )
    @ApiResponse(
            message = "Success",
            code = 200,
            response = PropertyDTO.class
    )
    @GetMapping(
            path = "/{propertyId}"
    )
    public PropertyDTO getPropertyById(@PathVariable Integer propertyId) {
        return propertyService.getPropertyById(propertyId);
    }

    @ApiOperation(
            value = "Get a property by some properties",
            response = PropertyDTO.class
    )
    @ApiResponse(
            message = "Success",
            code = 200,
            response = PropertyDTO.class
    )
    @GetMapping(
            value = "/search"
    )
    public List<PropertyDTO> getPropertyByOptions(@RequestParam(required = false) String searchParam,
                                                  @RequestParam(required = false) PropertyType propertyType,
                                                  @RequestParam(required = false) String city,
                                                  @RequestParam(required = false) Integer rooms,
                                                  @RequestParam(required = false) Double priceFrom,
                                                  @RequestParam(required = false) Double priceTo) {
        return propertyService.getPropertyByOptions(searchParam, propertyType, city, rooms, priceFrom, priceTo);
    }

    @ApiOperation(
            value = "Get three random properties",
            response = PropertyDTO.class
    )
    @ApiResponse(
            message = "Success",
            code = 200,
            response = PropertyDTO.class
    )
    @GetMapping(
            value = "/randomize"
    )
    public List<PropertyDTO> getRandomProperties() {
        return propertyService.getRandomProperty();
    }


}
