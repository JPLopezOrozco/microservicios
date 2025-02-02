package com.juan.product_service.controller;

import com.juan.product_service.model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping
    public Product newProduct(@RequestParam String id, @RequestParam(defaultValue = "false" ) Boolean throwError){
        if (throwError){
            throw new RuntimeException();
        }
        return new Product(id, "Notebook", 2000.0, "Instancia 1");
    }
}
