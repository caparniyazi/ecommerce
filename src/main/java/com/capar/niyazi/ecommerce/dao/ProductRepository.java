package com.capar.niyazi.ecommerce.dao;

import com.capar.niyazi.ecommerce.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin({"http://localhost:4200", "http://ecommerce-europe-bucket.s3-website.eu-north-1.amazonaws.com"})
public interface ProductRepository extends JpaRepository<Product, Long> {
    // A query method.
    // SELECT * FROM product where category_id=?
    // Spring Data REST automatically exposes end-point
    // http://localhost:8080/api/v1/products/search/findByCategoryId?id=2, for example.
    Page<Product> findByCategoryId(@Param("id") Long id, Pageable pageable);

    // SELECT * FROM Product p WHERE p.name like CONCAT('%', :name, '%')
    Page<Product> findByNameContaining(@Param("name") String name, Pageable pageable);
}
