package com.example.demo.apiController;

import com.example.demo.model.Product;
import com.example.demo.model.ProductDto;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
    @GetMapping("/{productId}")
    public Product getProduct(int productId) {
        return productService.getProduct(productId);
    }
    @PostMapping
    public String addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }
    @PutMapping("/{productId}")
    public String updateProduct(@PathVariable("productId") int productId, @RequestBody ProductDto productDto) {
        return productService.updateProduct(productId, productDto);
    }
    @DeleteMapping("/{productId}")
    public String deleteProduct(int productId) {
        return productService.deleteProduct(productId);
    }
}
