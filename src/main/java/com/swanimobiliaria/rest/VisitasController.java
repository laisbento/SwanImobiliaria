package com.swanimobiliaria.rest;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Api(value = "Visitas")
@RequestMapping("/visitas")
@RestController
public class VisitasController extends CrudRepository<Imovel, UUID> {



}
