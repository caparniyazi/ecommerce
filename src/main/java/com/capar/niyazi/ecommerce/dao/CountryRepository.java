package com.capar.niyazi.ecommerce.dao;

import com.capar.niyazi.ecommerce.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * @RepositoryRestResource is a Spring Data REST annotation.
 * It tells Spring Boot to automatically expose a JPA repository as a REST API, without writing a controller.
 */
@CrossOrigin({"http://localhost:4200", "http://ecommerce-europe-bucket.s3-website.eu-north-1.amazonaws.com"})
@RepositoryRestResource(collectionResourceRel = "countries", path = "countries")
public interface CountryRepository extends JpaRepository<Country, Integer> {
}
