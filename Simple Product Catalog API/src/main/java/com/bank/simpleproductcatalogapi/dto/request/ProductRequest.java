package com.bank.simpleproductcatalogapi.dto.request;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public class ProductRequest {

    @NotBlank(message = "name cannot be blank")
    private String name;

    @NotBlank(message = "description cannot be blank")
    private String description;

    @PositiveOrZero
    @DecimalMin("20")
    @DecimalMax("2000")
    private BigDecimal price;

    @NotBlank(message = "category cannot be blank")
    private String category;

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
