package com.example.orderservice.service;

import com.example.orderservice.model.Product;
import com.example.orderservice.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepo productRepo;

    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public Product createProduct(Product productRequest) {
        return productRepo.save(productRequest);
    }

    @Override
    public Product updateProduct(Product productRequest, Integer orderId) {
        productRequest.setId(orderId);
        return productRepo.save(productRequest)
                ;
    }

    @Override
    public Product getProductById(Integer orderId) {
        return productRepo.findById(orderId).orElse(null);

    }

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public void deleteProductById(Integer orderId) {
        
    }
}
