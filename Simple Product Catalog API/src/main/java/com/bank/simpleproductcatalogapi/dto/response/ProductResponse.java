package com.bank.simpleproductcatalogapi.dto.response;

import java.math.BigDecimal;
import java.time.Instant;

public class ProductResponse {
    private final String id;
    private final String name;
    private final String description;
    private final BigDecimal price;
    private final String category;
    private final Instant createdAt;

    public ProductResponse(String id, String name, String description, BigDecimal price, String category, Instant createdAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.createdAt = createdAt;
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

    public String getCategory() {
        return category;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}
