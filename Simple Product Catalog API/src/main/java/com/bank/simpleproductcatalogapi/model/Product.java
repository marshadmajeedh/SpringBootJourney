package com.bank.simpleproductcatalogapi.model;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public class Product {
    private final String id;
    private String name;
    private String description;
    private BigDecimal price;
    private String category;
    private final Instant createdAt;

    public Product(String name, String description, BigDecimal price, String category) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.createdAt = Instant.now();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public String getCategory() {
        return category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
