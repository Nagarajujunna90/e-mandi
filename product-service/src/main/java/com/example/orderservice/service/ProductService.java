package com.example.orderservice.service;

import com.example.orderservice.model.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(Product productRequest);

    Product updateProduct(Product productRequest, Integer orderId);

    Product getProductById(Integer orderId);

    List<Product> getAllProducts();

    void deleteProductById(Integer orderId);
}
