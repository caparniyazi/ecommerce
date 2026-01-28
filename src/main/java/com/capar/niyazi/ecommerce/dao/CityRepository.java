package com.capar.niyazi.ecommerce.dao;

import com.capar.niyazi.ecommerce.entity.City;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin({"http://localhost:4200", "http://ecommerce-europe-bucket.s3-website.eu-north-1.amazonaws.com"})
@RepositoryRestResource
public interface CityRepository extends JpaRepository<City, Integer> {
    List<City> findByCountryCode(@Param("code") String code, Sort sort);
}
