package com.primarchan.catalogservice.repository;

import com.primarchan.catalogservice.entity.CatalogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CatalogRepository extends JpaRepository<CatalogEntity, Long> {

    Optional<CatalogEntity> findByProductId(String productId);

}
