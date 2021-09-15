package com.luv2code.ecommerce.dao;

import com.luv2code.ecommerce.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

// CustomerRepository is NOT annotated: Hence it will NOT be exposed as REST API based on our configurations
// http://localhost:8080/api/customers
// @RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByEmail(String theEmail); // Method returns null if not found

}
