package com.example.demo.repository;

import com.example.demo.model.Post;
import com.example.demo.model.Product;
import com.example.demo.model.ProductDto;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
    Product findById(int productId);
    Product insert(Product product);
    Product update(int productId, Product product);
    Product delete(int productId);
}
