package com.capar.niyazi.ecommerce.dao;

import com.capar.niyazi.ecommerce.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
