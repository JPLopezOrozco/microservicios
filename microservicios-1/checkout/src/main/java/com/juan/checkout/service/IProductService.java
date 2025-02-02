package com.juan.checkout.service;

import com.juan.checkout.model.dto.Product;


public interface IProductService {
    Product getProduct(String id);
}
