package com.bank.simpleproductcatalogapi.service;

import com.bank.simpleproductcatalogapi.dto.request.ProductRequest;
import com.bank.simpleproductcatalogapi.dto.response.ProductResponse;
import com.bank.simpleproductcatalogapi.exception.ProductIdNotFoundException;
import com.bank.simpleproductcatalogapi.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private final List<Product> products;
    public ProductService() {
        this.products =  new ArrayList<>();
    }

    //create a product
    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = new Product(productRequest.getName(),productRequest.getDescription(),productRequest.getPrice(),productRequest.getCategory());
        products.add(product);

        return new ProductResponse(product.getId(),product.getName(),product.getDescription(),product.getPrice(),product.getCategory(),product.getCreatedAt());
    }

    //get all products
    public List<ProductResponse> getProducts() {
        return products.stream()
                .map(product -> new ProductResponse(
                        product.getId(),
                        product.getName(),
                        product.getDescription(),
                        product.getPrice(),
                        product.getCategory(),
                        product.getCreatedAt()
                ))
                .toList();
    }

    //get a product by its id
    public ProductResponse getProductById(String id){
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .map(product -> new ProductResponse(product.getId(),product.getName(),product.getDescription(),product.getPrice(),product.getCategory(),product.getCreatedAt()))
                .findFirst()
                .orElseThrow(() -> new ProductIdNotFoundException("Product with id " + id + " not found"));

    }

    //update a product by its id
    public ProductResponse updateProductById(String id, ProductRequest productRequest) {
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .peek(product -> {
                    product.setName(productRequest.getName());
                    product.setDescription(productRequest.getDescription());
                    product.setPrice(productRequest.getPrice());
                    product.setCategory(productRequest.getCategory());
                })
                .map(product -> new ProductResponse(product.getId(),product.getName(),product.getDescription(),product.getPrice(),product.getCategory(),product.getCreatedAt()))
                .findFirst()
                .orElseThrow(() -> new ProductIdNotFoundException("Product with id " + id + " not found"));
    }

    //delete a product
    public ProductResponse deleteProductById(String id) {

        Product productToDelete = products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ProductIdNotFoundException("Product with id " + id + " not found"));
        products.remove(productToDelete);

        return new ProductResponse(productToDelete.getId(),productToDelete.getName(),productToDelete.getDescription(),productToDelete.getPrice(),productToDelete.getCategory(),productToDelete.getCreatedAt());
    }


}
