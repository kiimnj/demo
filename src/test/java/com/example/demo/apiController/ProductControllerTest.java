package com.example.demo.apiController;

import com.example.demo.model.Product;
import com.example.demo.repository.MemoryProductRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class ProductControllerTest {
    ProductRepository productRepository = new MemoryProductRepository();
    ProductService productService = new ProductService(productRepository);
    ProductController productController = new ProductController(productService);
    @Test
    void getAllProduct() {
    }

    @Test
    void getProduct() {
    }

    @Test
    void addProduct() {
        Product product = Product.builder()
                .productName("테스트1")
                .maker("테스트메이커")
                .price(1000)
                .qty(1200)
                .build();
        String s = productController.addProduct(product);
        assertThat(s).isEqualTo("제품 추가 성공");
    }

    @Test
    void updateProduct() {
    }

    @Test
    void deleteProduct() {
    }
}