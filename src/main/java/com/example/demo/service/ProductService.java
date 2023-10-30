package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.model.ProductDto;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProduct() {
        List<Product> allProducts = productRepository.findAll();
        return allProducts;
    }
    public Product getProduct(int productId) {
        Product product = productRepository.findById(productId);
        return product;
    }
    public String addProduct(Product product) {
        String msg = "";
        Product inserted = productRepository.insert(product);
        if (inserted == null) {
            msg = "제품 추가 성공";
        } else {
            msg = "제품 추가 실패";
        }
        return msg;
    }
    public String updateProduct(int productId, ProductDto productDto) {
        String msg = "";
        Product product = productRepository.findById(productId);
        product.setQty(productDto.getQty());
        Product updated = productRepository.update(productId, product);
        if (updated != null) {
            msg = "제품 수정 성공";
        } else {
            msg = "제품 수정 실패";
        }
        return msg;
    }
    public String deleteProduct(int productId, Product product) {
        String msg = "";
        Product deleted = productRepository.delete(productId, product);
        if (deleted != null) {
            msg = "제품 삭제 성공";
        } else {
            msg = "제품 삭제 실패";
        }
        return msg;
    }
}
