package com.primarchan.catalogservice.controller;

import com.primarchan.catalogservice.dto.ResponseCatalog;
import com.primarchan.catalogservice.entity.CatalogEntity;
import com.primarchan.catalogservice.service.CatalogService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/catalog-service")
@RequiredArgsConstructor
public class CatalogController {

    private final Environment env;
    private final CatalogService catalogService;

    @GetMapping("/health_check")
    public String status() {
        return String.format("It's working in CATALOG SERVICE on PORT %s", env.getProperty("local.server.port"));
    }

    @GetMapping("/catalogs")
    public ResponseEntity<List<ResponseCatalog>> getCatalogs() {
        Iterable<CatalogEntity> catalogEntities = catalogService.getAllCatalogs();
        List<ResponseCatalog> responseCatalogs = new ArrayList<>();
        catalogEntities.forEach(entity -> {
            responseCatalogs.add(new ModelMapper().map(entity, ResponseCatalog.class));
        });

        return ResponseEntity.status(HttpStatus.OK).body(responseCatalogs);
    }

}
