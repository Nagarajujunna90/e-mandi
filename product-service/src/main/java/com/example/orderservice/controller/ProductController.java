package com.example.orderservice.controller;

import com.example.orderservice.model.Product;
import com.example.orderservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product/v1")
public class ProductController {
    @Autowired
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/product")
    public ResponseEntity<Product> createProduct(@RequestBody Product productRequest) {
        Product product = productService.createProduct(productRequest);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PutMapping("/product/{orderId}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product productRequest, @PathVariable("id") Integer productId) {
        Product product = productService.updateProduct(productRequest, productId);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("/product/{orderId}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Integer productId) {
        Product product = productService.getProductById(productId);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("/orders")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> productList = productService.getAllProducts();
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @DeleteMapping("/product/{productId}")
    public ResponseEntity<String> deleteProductById(@PathVariable("id") Integer productId) {
        productService.deleteProductById(productId);
        return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
    }
}
