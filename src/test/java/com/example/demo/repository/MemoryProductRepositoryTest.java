package com.example.demo.repository;

import com.example.demo.model.Product;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class MemoryProductRepositoryTest {
    ProductRepository productRepository = new MemoryProductRepository();
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findAll() {
        List<Product> allProduct = productRepository.findAll();
//        System.out.println(allProduct.size());
        Assertions.assertThat(allProduct.size()).isEqualTo(2);
    }

    @Test
    void findById() {
        Product product = productRepository.findById(1);
        Assertions.assertThat(product.getProductName()).isEqualTo("제품명1");
    }

    @Test
    void 제품추가테스트() {
        Product product = Product.builder()
                .productName("테스트1")
                .maker("테스트메이커")
                .price(1000)
                .qty(1200)
                .build();
        Product insertProduct = productRepository.insert(product);
        Assertions.assertThat(insertProduct.getProductId()).isEqualTo(2);
    }
}