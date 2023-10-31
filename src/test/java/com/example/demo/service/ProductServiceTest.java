package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.MemoryProductRepository;
import com.example.demo.repository.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class ProductServiceTest {
    ProductRepository productRepository = new MemoryProductRepository();
    ProductService productService = new ProductService(productRepository);
    @Test
    void 새로운제품추가() {
        Product product = Product.builder()
                .productName("테스트1")
                .maker("테스트메이커")
                .price(1000)
                .qty(1200)
                .build();
        String s = productService.addProduct(product);
        assertThat(s).isEqualTo("제품 추가 성공");
        assertThat(productService.getAllProducts().size()).isEqualTo(2);
    }

//    @Test
//    void getProduct() {
//    }
//
//    @Test
//    void addProduct() {
//    }
//
//    @Test
//    void updateProduct() {
//    }
//
//    @Test
//    void deleteProduct() {
//    }
}