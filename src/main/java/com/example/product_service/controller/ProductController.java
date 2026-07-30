package com.example.product_service.controller;

import com.example.product_service.dto.ProductDTO;
import com.example.product_service.entity.Product;
import com.example.product_service.service.ProductService;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService service;
    private final Environment environment;

    public ProductController(ProductService service, Environment environment) {

        this.service = service;
        this.environment = environment;
    }

    @GetMapping
    public List<ProductDTO> getAll() {
        String port = environment.getProperty("local.server.port");
        System.out.println(
                ">>> GET /api/products served by PRODUCT-SERVICE on port: " + port
        );
        return service.getAllProducts();
    }

    @GetMapping("/{id:\\d+}")
    public ProductDTO getById(@PathVariable Long id) {
        String port = environment.getProperty("local.server.port");

        System.out.println(
                ">>> GET /api/products/" + id
                        + " served by PRODUCT-SERVICE on port: "
                        + port
        );

        return service.getProductById(id);

    }

    @PostMapping
    public ProductDTO create(@RequestBody Product product) {
        return service.createProduct(product);
    }

    @PutMapping("/{id:\\d+}")
    public ProductDTO update(@PathVariable Long id, @RequestBody Product product) {
        return service.updateProduct(id, product);
    }

    @DeleteMapping("/{id:\\d+}")
    public String delete(@PathVariable Long id) {
        service.deleteProduct(id);
        return "Product deleted";
    }
}