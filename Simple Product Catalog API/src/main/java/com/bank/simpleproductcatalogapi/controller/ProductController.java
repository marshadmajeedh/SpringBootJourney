package com.bank.simpleproductcatalogapi.controller;

import com.bank.simpleproductcatalogapi.dto.request.ProductRequest;
import com.bank.simpleproductcatalogapi.dto.response.ProductResponse;
import com.bank.simpleproductcatalogapi.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //create
    @PostMapping("/products")
    public ResponseEntity<ProductResponse> createProduct(@Valid @RequestBody ProductRequest productRequest) {
        ProductResponse productResponse = productService.createProduct(productRequest);
        return ResponseEntity.ok(productResponse);
    }

    //get all
    @GetMapping("/products")
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        List<ProductResponse> productResponses = productService.getProducts();
        return ResponseEntity.ok(productResponses);
    }

    //get by id
    @GetMapping("/products/{id}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable String id) {
        ProductResponse productResponse = productService.getProductById(id);
        return ResponseEntity.ok(productResponse);
    }

    //update
    @PutMapping("/products/{id}")
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable String id,@Valid @RequestBody ProductRequest productRequest) {
        ProductResponse productResponse = productService.updateProductById(id, productRequest);
        return ResponseEntity.ok(productResponse);
    }

    //delete
    @DeleteMapping("/products/{id}")
    public ResponseEntity<ProductResponse> deleteProduct(@PathVariable String id) {
        ProductResponse productResponse = productService.deleteProductById(id);
        return ResponseEntity.ok(productResponse);
    }

}
