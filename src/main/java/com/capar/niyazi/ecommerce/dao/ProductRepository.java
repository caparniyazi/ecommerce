package com.capar.niyazi.ecommerce.dao;

import com.capar.niyazi.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
