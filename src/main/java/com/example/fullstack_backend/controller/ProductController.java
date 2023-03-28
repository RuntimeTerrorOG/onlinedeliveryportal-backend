package com.example.fullstack_backend.controller;

import com.example.fullstack_backend.model.Product;
import com.example.fullstack_backend.repository.ProductRepository;
import com.example.fullstack_backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class ProductController {


    @Autowired
    private ProductService productService;

    @PostMapping("/postProduct")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product savedProduct = productService.saveProduct(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }


//    @GetMapping("/newProduct")
//    List<Product>getAllUsers(){
//        return ProductService.fingall();
//    }

}