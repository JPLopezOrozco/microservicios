package com.juan.checkout.service.impl;

import com.juan.checkout.model.dto.Product;
import com.juan.checkout.repository.FeignProductRepository;
import com.juan.checkout.service.IProductService;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {

    private final FeignProductRepository feignProductRepository;
    Logger log = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    public ProductService(FeignProductRepository feignProductRepository) {
        this.feignProductRepository = feignProductRepository;
    }

    @Override
    @CircuitBreaker(name = "product", fallbackMethod = "getProductFallbackMethod")
    public Product getProduct(String id) {
        log.info("Intentando Obtener el producto con ID : "+  id);
        return feignProductRepository.getProductById(id,true);
    }

    public Product getProductFallbackMethod(String id,CallNotPermittedException exception ) {
        log.error("Circuit breaker en estado Open");
        return new Product();
    }
}
