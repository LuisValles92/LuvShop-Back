package com.luv2code.ecommerce.dao;

import com.luv2code.ecommerce.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestParam;

@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Long> { // Entity - Primary Key

    // Spring will execute a query similar to this: SELECT * FROM `full-stack-ecommerce`.product where category_id=?
    // Spring Data REST automatically exposes endpoint: http://localhost:8080/api/products/search/findByCategoryId?id=1
    Page<Product> findByCategoryId(@RequestParam("id") Long id, Pageable pageable);

    // search box
    // Spring will execute a query similar to this: SELECT * FROM `full-stack-ecommerce`.product p where p.name LIKE CONCAT('%', :name ,'%')
    Page<Product> findByNameContaining(@RequestParam("name") String name, Pageable pageable);

}
