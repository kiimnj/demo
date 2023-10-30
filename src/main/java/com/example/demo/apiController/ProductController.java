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


    @GetMapping("/products")
    public List<Product> getAllProduct() {
        return productService.getAllProduct();
    }
    @GetMapping("/products")
    public Product getProduct(int productId) {
        return productService.getProduct(productId);
    }
    @PostMapping("/products")
    public String addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }
    @PutMapping("/products/{productId}")
    public String updateProduct(@PathVariable("productId") int productId, @RequestBody ProductDto productDto) {
        return productService.updateProduct(productId, productDto);
    }
    public String deleteProduct(int productId, Product product) {
        return productService.deleteProduct(productId, product);
    }
}
