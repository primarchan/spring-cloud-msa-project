package com.primarchan.catalogservice.service;

import com.primarchan.catalogservice.entity.CatalogEntity;

public interface CatalogService {

    Iterable<CatalogEntity> getAllCatalogs();

}
