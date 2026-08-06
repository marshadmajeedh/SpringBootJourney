package com.bank.simpleproductcatalogapi.service;

import com.bank.simpleproductcatalogapi.dto.request.ProductRequest;
import com.bank.simpleproductcatalogapi.dto.response.ProductResponse;
import com.bank.simpleproductcatalogapi.exception.ProductIdNotFoundException;
import com.bank.simpleproductcatalogapi.model.Product;
import com.bank.simpleproductcatalogapi.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //create a product
    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = new Product(productRequest.getName(),productRequest.getDescription(),productRequest.getPrice(),productRequest.getCategory());
        Product savedProduct = productRepository.save(product);
        return new ProductResponse(savedProduct.getId(),savedProduct.getName(),savedProduct.getDescription(),savedProduct.getPrice(),savedProduct.getCategory(),savedProduct.getCreatedAt());
    }

    //get all products
    public List<ProductResponse> getProducts() {
        return productRepository.findAll()
                .stream()
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
        Product product = productRepository.findById(id).
                orElseThrow(()->new ProductIdNotFoundException("Product with "+id+" not found"));
        return new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice(), product.getCategory(), product.getCreatedAt());

    }

    //update a product by its id
    public ProductResponse updateProductById(String id, ProductRequest productRequest) {
        Product product = productRepository.findById(id).
                orElseThrow(()->new ProductIdNotFoundException("Product with "+id+" not found"));
        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        product.setPrice(productRequest.getPrice());
        product.setCategory(productRequest.getCategory());
        productRepository.save(product);

        return new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice(), product.getCategory(), product.getCreatedAt());
    }

    //delete a product
    public ProductResponse deleteProductById(String id) {
        Product product = productRepository.findById(id).
                orElseThrow(()->new ProductIdNotFoundException("Product with "+id+" not found"));
        productRepository.delete(product);

        return new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice(), product.getCategory(), product.getCreatedAt());
    }


}
