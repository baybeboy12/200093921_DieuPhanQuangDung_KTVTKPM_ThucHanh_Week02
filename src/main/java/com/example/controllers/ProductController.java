package com.example.controllers;

import com.example.models.Product;
import com.example.models.Users;
import com.example.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    RestTemplate restTemplate = new RestTemplate();
    @GetMapping("products")
    List<Product> getAllProduct(){
        return productRepository.findAll();
    }
    @GetMapping("/products/{id}")
    public Product getApiProduct(@PathVariable("id")long id){
        Users user = restTemplate.getForObject("http://localhost:8082/users/"+id,Users.class);
        Product product = productRepository.findById(id).get();
        product.setUsers(user);
        return product;
    }
}
