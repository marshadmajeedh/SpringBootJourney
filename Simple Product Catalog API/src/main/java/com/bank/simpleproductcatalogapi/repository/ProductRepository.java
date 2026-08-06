package com.bank.simpleproductcatalogapi.repository;

import com.bank.simpleproductcatalogapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
