package com.capar.niyazi.ecommerce.dao;

import com.capar.niyazi.ecommerce.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * RepositoryRestResource: It exposes your repository as a RESTful endpoint automatically
 * (without writing a controller).
 * So instead of writing a controller and service manually, Spring Data REST generates CRUD REST endpoints for you.
 * collectionResourceRel: Name of JSON entry
 * product-category: Name of the reference path.
 */
@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "productCategory", path = "product-category")
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
}
